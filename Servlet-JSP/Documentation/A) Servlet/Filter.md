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

![img](data:image/jpeg;base64,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)

## Examples
```java
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

@WebFilter("/*")
public class F_LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();
        boolean loggedIn = (session != null && session.getAttribute("user") != null);
        String loginURI = req.getContextPath() + "/F_Login.jsp";
        String loginServletURI = req.getContextPath() + "/login";

        boolean isLoginRequest = req.getRequestURI().equals(loginURI) || req.getRequestURI().equals(loginServletURI);

        if (loggedIn || isLoginRequest) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(loginURI);
        }
    }

    public void destroy() {}
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