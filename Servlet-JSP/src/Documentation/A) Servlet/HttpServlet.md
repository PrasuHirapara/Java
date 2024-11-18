# HttpServlet Class
The `HttpServlet` class, part of the `javax.servlet.http` package, is a base class provided by Java to create HTTP servlets. It simplifies the process of handling HTTP requests and responses in web applications. It extends the `GenericServlet` class and provides specific methods for handling HTTP-specific functionality.

### Features
- Simplifies handling of HTTP GET, POST, PUT, DELETE, and other methods.
- Supports session management and request handling.
- Provides hooks for lifecycle management of servlets.

## Commonly Used Methods
| Method | Description |
|--------|-------------|
| `void doGet(HttpServletRequest req, HttpServletResponse resp)` | Handles HTTP GET requests. |
| `void doPost(HttpServletRequest req, HttpServletResponse resp)` | Handles HTTP POST requests. |
| `void doPut(HttpServletRequest req, HttpServletResponse resp)` | Handles HTTP PUT requests. |
| `void doDelete(HttpServletRequest req, HttpServletResponse resp)` | Handles HTTP DELETE requests. |
| `void init()` | Initializes the servlet. |
| `void destroy()` | Cleans up resources before the servlet is destroyed. |
| `long getLastModified(HttpServletRequest req)` | Returns the last modified time for a resource. |
| `void service(HttpServletRequest req, HttpServletResponse resp)` | Dispatches HTTP requests to the appropriate `doXXX` methods. |
| `String getServletInfo()` | Returns information about the servlet. |
| `ServletConfig getServletConfig()` | Returns the configuration object for the servlet. |
| `void log(String message)` | Logs messages for debugging purposes. |
| `void log(String message, Throwable t)` | Logs messages and stack traces for errors. |
| `Enumeration<String> getInitParameterNames()` | Retrieves the names of initialization parameters. |

## Examples

### 1. Handling GET Requests (`doGet`)
**Example:**
```java
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    out.println("<h1>Hello from HttpServlet!</h1>");
}
```

### 2. Handling POST Requests (`doPost`)
**Example:**
```java
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = req.getParameter("name");
    resp.setContentType("text/plain");
    resp.getWriter().write("Hello, " + name + "!");
}
```

### 3. Handling PUT Requests (`doPut`)
**Example:**
```java
@Override
protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // Process PUT request
    resp.setStatus(HttpServletResponse.SC_OK);
}
```

### 4. Overriding `init()`
**Example:**
```java
@Override
public void init() throws ServletException {
    // Perform initialization tasks
    System.out.println("Servlet initialized!");
}
```

### 5. Overriding `destroy()`
**Example:**
```java
@Override
public void destroy() {
    // Perform cleanup tasks
    System.out.println("Servlet is being destroyed.");
}
```

### 6. Handling DELETE Requests (`doDelete`)
**Example:**
```java
@Override
protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // Handle DELETE request
    resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
}
```

### 7. Using `service` Method
**Example:**
```java
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String method = req.getMethod();
    resp.getWriter().write("Received HTTP method: " + method);
}
```

### 8. Logging Messages (`log`)
**Example:**
```java
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    log("Handling GET request");
}
```

### 9. Using Initialization Parameters
**Example:**
```java
@Override
public void init() throws ServletException {
    String param = getServletConfig().getInitParameter("exampleParam");
    System.out.println("Initialization parameter: " + param);
}
```

### 10. Returning Last Modified Time (`getLastModified`)
**Example:**
```java
@Override
protected long getLastModified(HttpServletRequest req) {
    return System.currentTimeMillis();
}
```

### 11. Retrieving Servlet Info
**Example:**
```java
@Override
public String getServletInfo() {
    return "Example HttpServlet";
}
```

### 12. Using Request Attributes
**Example:**
```java
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("exampleAttribute", "value");
    resp.getWriter().write("Attribute set successfully.");
}
```

### 13. Setting HTTP Headers
**Example:**
```java
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setHeader("Custom-Header", "HeaderValue");
    resp.getWriter().write("Header set successfully.");
}
```

## Additional Notes
- **Lifecycle Methods**: `init`, `service`, and `destroy` manage the lifecycle of a servlet.
- **Thread Safety**: Servlets are multithreaded; ensure shared resources are synchronized.
- **Session Management**: Use `HttpSession` to maintain state across multiple requests.
- **Error Handling**: Override `service` or implement error-specific logic for better debugging.

## Use Cases
- Building REST APIs for web services.
- Generating dynamic content such as HTML, JSON, or XML.
- Handling HTTP-specific tasks like redirection, authentication, and session tracking.
