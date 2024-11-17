# Filter
The `Filter` interface, part of the `javax.servlet` package, is used to intercept and process requests and responses in Java web applications. Filters are typically used for tasks such as authentication, logging, input validation, or data compression.

## Key Features
- Provides a mechanism to modify incoming requests and outgoing responses.
- Can be used for preprocessing and postprocessing requests.
- Configurable via annotations or `web.xml` file.

### Core Interfaces
**Filter**
- `void init(FilterConfig config)`: Initializes the filter with configuration parameters.
- `void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)`: Processes requests and responses. Calls `chain.doFilter()` to forward the request/response to the next entity.
- `void destroy()`: Cleans up resources when the filter is removed.

**FilterConfig**
- Provides initialization parameters and access to the `ServletContext`.
- Methods include `getFilterName()`, `getInitParameter()`, and `getServletContext()`.

**FilterChain**
- Used to forward requests and responses to the next filter or target resource via `doFilter()`.

## Commonly Used Methods
| Method | Description |
|--------|-------------|
| `void init(FilterConfig filterConfig)` | Called by the web container to initialize the filter. |
| `void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)` | Intercepts the request and response, processes them, and optionally passes them to the next filter or servlet in the chain. |
| `void destroy()` | Called by the web container to indicate that the filter is being taken out of service. |
| `FilterConfig getFilterConfig()` | Retrieves the filter configuration. |
| `String getInitParameter(String name)` | Returns the value of the specified initialization parameter. |
| `Enumeration<String> getInitParameterNames()` | Returns an enumeration of initialization parameter names. |

## Lifecycle of a Filter
1. **Initialization**: The `init` method is called once during the filter's initialization.
2. **Filtering**: The `doFilter` method is invoked for each request.
3. **Destruction**: The `destroy` method is called once during the filter's destruction.

## Examples

### 1. Basic Filter Implementation
**Example:**
```java
import javax.servlet.*;
import java.io.IOException;

public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoggingFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("Request received at " + System.currentTimeMillis());
        chain.doFilter(request, response);
        System.out.println("Response sent at " + System.currentTimeMillis());
    }

    @Override
    public void destroy() {
        System.out.println("LoggingFilter destroyed");
    }
}
```

### 2. Filter Configuration in `web.xml`
```xml
<filter>
    <filter-name>LoggingFilter</filter-name>
    <filter-class>com.example.LoggingFilter</filter-class>
</filter>
<filter-mapping>
    <filter-name>LoggingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

### 3. Filter Configuration with Annotations
**Example:**
```java
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization logic
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Preprocessing
        System.out.println("Before processing request");
        chain.doFilter(request, response);
        // Postprocessing
        System.out.println("After processing response");
    }

    @Override
    public void destroy() {
        // Cleanup logic
    }
}
```

## Additional Notes
- Filters can be chained together to perform a sequence of operations on a request or response.
- The `FilterChain` object is used to pass the request and response to the next filter or resource.
- Filters can be applied to specific URL patterns or servlets.

## Use Cases
- Authentication and authorization.
- Logging request and response details.
- Data compression (e.g., GZIP).
- Modifying request headers or parameters.
- Caching and performance optimizations.