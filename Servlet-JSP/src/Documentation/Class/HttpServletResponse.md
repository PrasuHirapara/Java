# HttpServletResponse Interface
The `HttpServletResponse` interface, part of the `javax.servlet.http` package, is used by a servlet to customize the HTTP response sent to the client. It provides methods to set response headers, status codes, cookies, and the response body.

## Commonly Used Methods
| Method | Description |
|--------|-------------|
| `void setContentType(String type)` | Sets the MIME type of the response. |
| `PrintWriter getWriter()` | Returns a `PrintWriter` object to send character data to the client. |
| `void setHeader(String name, String value)` | Sets a response header with the given name and value. |
| `void addHeader(String name, String value)` | Adds a response header with the given name and value. |
| `void setStatus(int sc)` | Sets the status code for the response. |
| `void sendError(int sc, String msg)` | Sends an error response with the specified status code and message. |
| `void sendRedirect(String location)` | Sends a temporary redirect response to the client. |
| `void addCookie(Cookie cookie)` | Adds a `Cookie` to the response. |
| `String encodeURL(String url)` | Encodes the specified URL for use in the response. |
| `void setCharacterEncoding(String charset)` | Sets the character encoding for the response. |

## Examples

### 1. `setContentType(String type)`
**Example:**
```java
response.setContentType("text/html");
```

### 2. `getWriter()`
**Example:**
```java
PrintWriter out = response.getWriter();
out.println("<h1>Hello, World!</h1>");
```

### 3. `setHeader(String name, String value)`
**Example:**
```java
response.setHeader("Cache-Control", "no-cache");
```

### 4. `addHeader(String name, String value)`
**Example:**
```java
response.addHeader("Custom-Header", "HeaderValue");
```

### 5. `setStatus(int sc)`
**Example:**
```java
response.setStatus(HttpServletResponse.SC_OK); // Sets status to 200 OK
```

### 6. `sendError(int sc, String msg)`
**Example:**
```java
response.sendError(HttpServletResponse.SC_NOT_FOUND, "Resource not found");
```

### 7. `sendRedirect(String location)`
**Example:**
```java
response.sendRedirect("https://www.example.com");
```

### 8. `addCookie(Cookie cookie)`
**Example:**
```java
Cookie cookie = new Cookie("username", "JohnDoe");
cookie.setMaxAge(3600); // 1 hour
response.addCookie(cookie);
```

### 9. `encodeURL(String url)`
**Example:**
```java
String encodedURL = response.encodeURL("https://www.example.com/login");
System.out.println("Encoded URL: " + encodedURL);
```

### 10. `setCharacterEncoding(String charset)`
**Example:**
```java
response.setCharacterEncoding("UTF-8");
```

## Use Cases
- Generating dynamic HTML or JSON responses.
- Sending HTTP status codes and custom headers.
- Handling redirection in web applications.
- Managing cookies for client-server communication.
