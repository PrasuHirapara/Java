# Cookie Class
The `Cookie` class, part of the `javax.servlet.http` package, is used to create and manage cookies in Java web applications. Cookies are small pieces of information stored on the client side and sent back to the server with each HTTP request.

## Key Features
- Stores client-specific information such as user preferences or session data.
- Enables state management in a stateless HTTP protocol.
- Offers control over cookie properties like expiration, domain, and path.

## Commonly Used Methods
| Method | Description |
|--------|-------------|
| `String getName()` | Returns the name of the cookie. |
| `String getValue()` | Returns the value of the cookie. |
| `void setValue(String value)` | Sets the value of the cookie. |
| `void setMaxAge(int expiry)` | Sets the maximum age of the cookie in seconds. |
| `int getMaxAge()` | Returns the maximum age of the cookie in seconds. |
| `void setPath(String uri)` | Specifies a path for which the cookie is valid. |
| `String getPath()` | Returns the path for which the cookie is valid. |
| `void setDomain(String domain)` | Specifies the domain for which the cookie is valid. |
| `String getDomain()` | Returns the domain of the cookie. |
| `void setSecure(boolean flag)` | Marks the cookie as secure (sent over HTTPS only). |
| `boolean getSecure()` | Returns whether the cookie is marked as secure. |
| `void setHttpOnly(boolean isHttpOnly)` | Marks the cookie as HTTP-only (not accessible via JavaScript). |
| `boolean isHttpOnly()` | Returns whether the cookie is marked as HTTP-only. |

## Examples

### 1. Creating a Cookie
**Example:**
```java
Cookie cookie = new Cookie("username", "JohnDoe");
response.addCookie(cookie);
```

### 2. Retrieving Cookies
**Example:**
```java
Cookie[] cookies = request.getCookies();
if (cookies != null) {
    for (Cookie cookie : cookies) {
        if ("username".equals(cookie.getName())) {
            response.getWriter().write("Hello, " + cookie.getValue());
        }
    }
}
```

### 3. Setting Expiration Time
**Example:**
```java
Cookie cookie = new Cookie("username", "JohnDoe");
cookie.setMaxAge(3600); // Expires in 1 hour
response.addCookie(cookie);
```

### 4. Marking as Secure
**Example:**
```java
Cookie cookie = new Cookie("sessionToken", "abc123");
cookie.setSecure(true); // Sent over HTTPS only
response.addCookie(cookie);
```

### 5. Marking as HTTP-Only
**Example:**
```java
Cookie cookie = new Cookie("authToken", "secureValue");
cookie.setHttpOnly(true); // Not accessible via JavaScript
response.addCookie(cookie);
```

### 6. Specifying a Domain and Path
**Example:**
```java
Cookie cookie = new Cookie("sitePreference", "darkMode");
cookie.setDomain(".example.com"); // Valid for all subdomains of example.com
cookie.setPath("/"); // Valid for the entire site
response.addCookie(cookie);
```

### 7. Updating a Cookie's Value
**Example:**
```java
Cookie[] cookies = request.getCookies();
if (cookies != null) {
    for (Cookie cookie : cookies) {
        if ("username".equals(cookie.getName())) {
            cookie.setValue("UpdatedUser");
            response.addCookie(cookie);
        }
    }
}
```

### 8. Deleting a Cookie
**Example:**
```java
Cookie cookie = new Cookie("username", "");
cookie.setMaxAge(0); // Expires immediately
response.addCookie(cookie);
```

## Additional Notes
- **Cookie Size Limit**: Most browsers limit cookie size to 4KB.
- **Security Best Practices**:
    - Use `setSecure(true)` for sensitive data to ensure cookies are transmitted over HTTPS.
    - Use `setHttpOnly(true)` to prevent client-side access via JavaScript.
    - Avoid storing sensitive information in cookies as they are visible to the client.
- **Cross-Domain Issues**: Use `setDomain` and `setPath` wisely to control cookie visibility.
- **Cookie Expiration**: If `setMaxAge` is not specified, the cookie will be a session cookie and will be removed when the browser is closed.

## Use Cases
- Session management (storing session tokens).
- User preferences (e.g., theme, language settings).
- Tracking user activity (e.g., analytics).
