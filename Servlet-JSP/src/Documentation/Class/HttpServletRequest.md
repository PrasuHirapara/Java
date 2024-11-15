# HttpServletRequest Interface
The `HttpServletRequest` interface, part of the `javax.servlet.http` package, provides information about the request made by the client to the server. It is widely used in Servlets to retrieve request parameters, headers, session information, and other data related to the HTTP request.

## Commonly Used Methods
| Method | Description |
|--------|-------------|
| `String getParameter(String name)` | Retrieves the value of a request parameter as a string. |
| `Enumeration<String> getParameterNames()` | Returns an enumeration of all request parameter names. |
| `String[] getParameterValues(String name)` | Retrieves all values of the specified request parameter as a string array. |
| `String getHeader(String name)` | Retrieves the value of the specified request header. |
| `Enumeration<String> getHeaderNames()` | Returns an enumeration of all request header names. |
| `String getMethod()` | Returns the HTTP method (e.g., GET, POST) used for the request. |
| `String getRequestURI()` | Returns the part of the request URL from the protocol name to the query string. |
| `String getQueryString()` | Returns the query string of the request. |
| `HttpSession getSession()` | Returns the current `HttpSession` associated with this request. |
| `String getRemoteAddr()` | Returns the IP address of the client making the request. |

## Examples

### 1. `getParameter(String name)`
**Example:**
```java
String username = request.getParameter("username");
System.out.println("Username: " + username);
```

### 2. `getParameterNames()`
**Example:**
```java
Enumeration<String> parameterNames = request.getParameterNames();
while (parameterNames.hasMoreElements()) {
    String paramName = parameterNames.nextElement();
    System.out.println("Parameter: " + paramName);
}
```

### 3. `getParameterValues(String name)`
**Example:**
```java
String[] values = request.getParameterValues("colors");
if (values != null) {
    for (String color : values) {
        System.out.println("Selected color: " + color);
    }
}
```

### 4. `getHeader(String name)`
**Example:**
```java
String userAgent = request.getHeader("User-Agent");
System.out.println("User-Agent: " + userAgent);
```

### 5. `getHeaderNames()`
**Example:**
```java
Enumeration<String> headerNames = request.getHeaderNames();
while (headerNames.hasMoreElements()) {
    String headerName = headerNames.nextElement();
    System.out.println(headerName + ": " + request.getHeader(headerName));
}
```

### 6. `getMethod()`
**Example:**
```java
String method = request.getMethod();
System.out.println("HTTP Method: " + method);
```

### 7. `getRequestURI()`
**Example:**
```java
String requestURI = request.getRequestURI();
System.out.println("Request URI: " + requestURI);
```

### 8. `getQueryString()`
**Example:**
```java
String queryString = request.getQueryString();
System.out.println("Query String: " + queryString);
```

### 9. `getSession()`
**Example:**
```java
HttpSession session = request.getSession();
session.setAttribute("username", "JohnDoe");
System.out.println("Session Attribute Set: " + session.getAttribute("username"));
```

### 10. `getRemoteAddr()`
**Example:**
```java
String clientIP = request.getRemoteAddr();
System.out.println("Client IP Address: " + clientIP);
```

## Use Cases
- Retrieving user input from form data.
- Handling headers for custom or security-related information.
- Managing sessions and cookies for a web application.
- Accessing request-specific information like URI and query strings.

