## CsrfFilter

### Introduction

* A servlet filter responsible for enforcing CSRF (Cross-Site Request Forgery) protection in Spring Security.
* Ensures that state-changing requests (e.g., POST, PUT, DELETE) contain a valid CSRF token.
* Rejects requests with missing or invalid CSRF tokens by sending a 403 (Forbidden) response.
* Commonly placed after `SecurityContextPersistenceFilter` and before filters that process authentication.
* Uses a `CsrfTokenRepository` to load and save CSRF tokens.

### Methods

| Return Type         | Method Name & Parameters                                                       | Description                                                              |
| ------------------- | ------------------------------------------------------------------------------ | ------------------------------------------------------------------------ |
| void                | `doFilter(ServletRequest req, ServletResponse res, FilterChain chain)`         | Performs CSRF token validation for HTTP requests and rejects if invalid. |
| void                | `setRequireCsrfProtectionMatcher(RequestMatcher requireCsrfProtectionMatcher)` | Defines a matcher to specify when CSRF protection is required.           |
| void                | `setCsrfTokenRepository(CsrfTokenRepository csrfTokenRepository)`              | Sets the repository used to store and retrieve CSRF tokens.              |
| CsrfTokenRepository | `getCsrfTokenRepository()`                                                     | Returns the configured CSRF token repository.                            |

### Code Implementation

```java
package org.springframework.security.web.csrf;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.io.IOException;

public class CsrfFilter implements javax.servlet.Filter {

    private CsrfTokenRepository csrfTokenRepository;
    private RequestMatcher requireCsrfProtectionMatcher;

    public CsrfFilter(CsrfTokenRepository csrfTokenRepository) {
        this.csrfTokenRepository = csrfTokenRepository;
        this.requireCsrfProtectionMatcher = new DefaultRequiresCsrfMatcher();
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        CsrfToken csrfToken = this.csrfTokenRepository.loadToken(request);
        if (this.requireCsrfProtectionMatcher.matches(request)) {
            if (csrfToken == null || !csrfToken.getToken().equals(request.getHeader(csrfToken.getHeaderName()))) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Invalid CSRF Token");
                return;
            }
        }
        chain.doFilter(req, res);
    }

    public void setRequireCsrfProtectionMatcher(RequestMatcher requireCsrfProtectionMatcher) {
        this.requireCsrfProtectionMatcher = requireCsrfProtectionMatcher;
    }

    public void setCsrfTokenRepository(CsrfTokenRepository csrfTokenRepository) {
        this.csrfTokenRepository = csrfTokenRepository;
    }

    public CsrfTokenRepository getCsrfTokenRepository() {
        return this.csrfTokenRepository;
    }
}
```
