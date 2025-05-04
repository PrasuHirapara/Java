# SecurityContextHolderFilter

## Introduction

* `SecurityContextHolderFilter` is a Spring Security filter used in the filter chain to manage the `SecurityContext` for each HTTP request.
* It ensures that the security context is available throughout the processing of the request.
* The filter clears the context after the request is complete to prevent memory leaks.
* It acts as a bridge between the HTTP request and Spring Security's context mechanism.

---

## Methods in SecurityContextHolderFilter

| Return Type               | Method Signature                                                                                | Description                                                                                 |
| ------------------------- | ----------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- |
| void                      | `doFilter(ServletRequest request, ServletResponse response, FilterChain chain)`                 | Main method that processes the security context and forwards the request through the chain. |
| void                      | `doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)` | Internally handles context loading and cleanup around the filter chain.                     |
| SecurityContextRepository | `getSecurityContextRepository()`                                                                | Returns the configured security context repository.                                         |
| void                      | `setSecurityContextRepository(SecurityContextRepository repository)`                            | Sets the security context repository to use.                                                |
| boolean                   | `isShouldRefreshContext()`                                                                      | Indicates whether the context should be refreshed.                                          |
| void                      | `setShouldRefreshContext(boolean refresh)`                                                      | Sets whether to refresh the context for each request.                                       |

---

## Implementation

```java
package com.example.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

public class SecurityContextHolderFilter extends GenericFilterBean {

    private SecurityContextRepository securityContextRepository;
    private boolean shouldRefreshContext = true;

    public SecurityContextHolderFilter(SecurityContextRepository securityContextRepository) {
        this.securityContextRepository = securityContextRepository;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        doFilterInternal((HttpServletRequest) request, (HttpServletResponse) response, chain);
    }

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpRequestResponseHolder holder = new HttpRequestResponseHolder(request, response);
        SecurityContext context = securityContextRepository.loadContext(holder);
        try {
            SecurityContextHolder.setContext(context);
            chain.doFilter(request, response);
        } finally {
            SecurityContextHolder.clearContext();
        }
    }

    public SecurityContextRepository getSecurityContextRepository() {
        return this.securityContextRepository;
    }

    public void setSecurityContextRepository(SecurityContextRepository repository) {
        this.securityContextRepository = repository;
    }

    public boolean isShouldRefreshContext() {
        return shouldRefreshContext;
    }

    public void setShouldRefreshContext(boolean refresh) {
        this.shouldRefreshContext = refresh;
    }
}
```

---

This class is essential for managing the security context lifecycle per request and is typically auto-configured by Spring Security in modern Spring Boot applications.
