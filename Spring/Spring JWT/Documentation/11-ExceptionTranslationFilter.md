## ExceptionTranslationFilter

### Introduction

* A Spring Security filter that handles exceptions thrown during the filter chain execution.
* Specifically designed to catch `AuthenticationException` and `AccessDeniedException`.
* Redirects unauthenticated users to the login page (or entry point) and handles access denials for authenticated users.
* Provides a clear separation between security exception handling and the actual request processing.
* Typically placed after `FilterSecurityInterceptor` in the filter chain.

### Key Collaborators

* **AuthenticationEntryPoint**: Used to start the authentication process when an unauthenticated user accesses a protected resource.
* **AccessDeniedHandler**: Handles situations where access is denied to an already authenticated user.

### Methods

| Return Type              | Method Name & Parameters                                               | Description                                                                 |
| ------------------------ | ---------------------------------------------------------------------- | --------------------------------------------------------------------------- |
| void                     | `doFilter(ServletRequest req, ServletResponse res, FilterChain chain)` | Wraps the filter chain in a try-catch block to process security exceptions. |
| void                     | `setAuthenticationEntryPoint(AuthenticationEntryPoint entryPoint)`     | Sets the strategy to handle unauthenticated access attempts.                |
| void                     | `setAccessDeniedHandler(AccessDeniedHandler handler)`                  | Sets the strategy to handle access denial for authenticated users.          |
| AuthenticationEntryPoint | `getAuthenticationEntryPoint()`                                        | Returns the configured entry point for authentication.                      |
| AccessDeniedHandler      | `getAccessDeniedHandler()`                                             | Returns the configured handler for access denied exceptions.                |

### Code Implementation

```java
package org.springframework.security.web.access;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

public class ExceptionTranslationFilter implements Filter {

    private AuthenticationEntryPoint authenticationEntryPoint;
    private AccessDeniedHandler accessDeniedHandler;

    public ExceptionTranslationFilter(AuthenticationEntryPoint entryPoint) {
        this.authenticationEntryPoint = entryPoint;
        this.accessDeniedHandler = new AccessDeniedHandlerImpl();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        try {
            chain.doFilter(request, response);
        } catch (AuthenticationException authEx) {
            authenticationEntryPoint.commence(request, response, authEx);
        } catch (AccessDeniedException accessDeniedEx) {
            accessDeniedHandler.handle(request, response, accessDeniedEx);
        }
    }

    public void setAuthenticationEntryPoint(AuthenticationEntryPoint authenticationEntryPoint) {
        this.authenticationEntryPoint = authenticationEntryPoint;
    }

    public void setAccessDeniedHandler(AccessDeniedHandler accessDeniedHandler) {
        this.accessDeniedHandler = accessDeniedHandler;
    }

    public AuthenticationEntryPoint getAuthenticationEntryPoint() {
        return authenticationEntryPoint;
    }

    public AccessDeniedHandler getAccessDeniedHandler() {
        return accessDeniedHandler;
    }
}
```