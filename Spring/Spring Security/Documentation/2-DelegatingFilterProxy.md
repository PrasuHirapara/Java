## DelegatingFilterProxy

### Introduction
- Acts as a bridge between the servlet container and Spring-managed security filters.
- Delegates the actual filtering work to a Spring bean named `springSecurityFilterChain`.
- Implements `javax.servlet.Filter`, making it compatible with the servlet filter chain.
- Simplifies filter registration by allowing Spring beans to be used as servlet filters.
- Commonly used to wrap Spring Security's filter chain.

### Methods

| Return Type | Method Name & Parameters                      | Description                                                    |
|-------------|-----------------------------------------------|----------------------------------------------------------------|
| void        | `init(FilterConfig filterConfig)`             | Initializes the filter and stores the configuration.           |
| void        | `doFilter(ServletRequest req, ServletResponse res, FilterChain chain)` | Delegates request handling to the Spring-managed filter bean.  |
| void        | `destroy()`                                   | Cleans up resources before the filter is destroyed.            |
| void        | `setTargetBeanName(String targetBeanName)`    | Sets the name of the Spring bean this proxy should delegate to.|
| void        | `setApplicationContext(ApplicationContext context)` | Sets the Spring `ApplicationContext` manually.           |
| Filter      | `getDelegate()`                               | Lazily loads and returns the target filter bean from the context. |

### Code Implementation

```java
package com.example.security;

import jakarta.servlet.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;

public class DelegatingFilterProxy implements Filter {

    private String targetBeanName;
    private ApplicationContext applicationContext;
    private Filter delegate;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.targetBeanName = filterConfig.getFilterName();
        ServletContext servletContext = filterConfig.getServletContext();
        this.applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        getDelegate().doFilter(request, response, chain);
    }

    @Override
    public void destroy() {
        if (delegate != null) {
            delegate.destroy();
        }
    }

    public void setTargetBeanName(String targetBeanName) {
        this.targetBeanName = targetBeanName;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    private Filter getDelegate() {
        if (delegate == null) {
            try {
                delegate = applicationContext.getBean(targetBeanName, Filter.class);
            } catch (BeansException e) {
                throw new IllegalStateException("Bean named '" + targetBeanName + "' not found in ApplicationContext", e);
            }
        }
        return delegate;
    }
}
```
