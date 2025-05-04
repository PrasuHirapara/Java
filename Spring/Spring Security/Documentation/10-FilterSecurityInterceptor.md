## FilterSecurityInterceptor

### Introduction

* The final filter in the Spring Security filter chain responsible for authorizing web requests.
* Uses `AccessDecisionManager` and `SecurityMetadataSource` to determine access rights.
* Handles URL-based authorization configured via HTTP security rules.
* Integrates with `SecurityContext` to retrieve authentication information.
* Commonly used with annotations or configuration rules like `antMatchers()`.

### Key Collaborators

* **AccessDecisionManager**: Makes final access control decisions based on authentication and configuration.
* **SecurityMetadataSource**: Provides metadata attributes (e.g., required roles) for secured objects (like URLs).

### Methods

| Return Type            | Method Name & Parameters                                                        | Description                                                               |
| ---------------------- | ------------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| void                   | `doFilter(ServletRequest request, ServletResponse response, FilterChain chain)` | Intercepts requests and performs access control decisions.                |
| void                   | `setAccessDecisionManager(AccessDecisionManager manager)`                       | Sets the strategy used to decide access based on config and auth details. |
| void                   | `setSecurityMetadataSource(SecurityMetadataSource metadataSource)`              | Sets metadata source used to retrieve secured object attributes.          |
| SecurityMetadataSource | `obtainSecurityMetadataSource()`                                                | Returns the configured metadata source.                                   |

### Code Implementation

```java
package org.springframework.security.web.access.intercept;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import java.io.IOException;

public class FilterSecurityInterceptor implements Filter {

    private AccessDecisionManager accessDecisionManager;
    private FilterInvocationSecurityMetadataSource securityMetadataSource;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        FilterInvocation fi = new FilterInvocation((HttpServletRequest) request, (HttpServletResponse) response, chain);
        invoke(fi);
    }

    private void invoke(FilterInvocation fi) throws IOException, ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        var attributes = securityMetadataSource.getAttributes(fi);
        accessDecisionManager.decide(authentication, fi, attributes);
        fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
    }

    public void setAccessDecisionManager(AccessDecisionManager accessDecisionManager) {
        this.accessDecisionManager = accessDecisionManager;
    }

    public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource securityMetadataSource) {
        this.securityMetadataSource = securityMetadataSource;
    }

    public FilterInvocationSecurityMetadataSource obtainSecurityMetadataSource() {
        return this.securityMetadataSource;
    }
}
```

## AccessDecisionManager (Overview)

### Introduction

* Interface responsible for making authorization decisions in Spring Security.
* Invoked by `FilterSecurityInterceptor` to evaluate whether access should be granted.
* Based on authentication info and `ConfigAttribute` metadata.

### Key Methods

| Return Type | Method Name & Parameters                                                             | Description                                                      |
| ----------- | ------------------------------------------------------------------------------------ | ---------------------------------------------------------------- |
| void        | `decide(Authentication auth, Object object, Collection<ConfigAttribute> attributes)` | Makes access decision for the secured object.                    |
| boolean     | `supports(ConfigAttribute attribute)`                                                | Indicates whether this manager can process the given attribute.  |
| boolean     | `supports(Class<?> clazz)`                                                           | Indicates whether this manager supports the secured object type. |
