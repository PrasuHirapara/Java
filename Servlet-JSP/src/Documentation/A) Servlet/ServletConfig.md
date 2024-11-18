# ServletConfig
The `ServletConfig` interface, part of the `javax.servlet` package, is used to configure a servlet during its initialization. It allows a servlet to access its initialization parameters and the servlet context.

## Key Features
- Provides initialization parameters specific to a servlet.
- Gives access to the `ServletContext` object, which is shared across the web application.
- Ensures each servlet can retrieve its own configuration data.

## Commonly Used Methods
| Method | Description |
|--------|-------------|
| `String getInitParameter(String name)` | Returns the value of the specified initialization parameter. |
| `Enumeration<String> getInitParameterNames()` | Returns an enumeration of all initialization parameter names. |
| `ServletContext getServletContext()` | Returns the `ServletContext` object for the servlet. |
| `String getServletName()` | Returns the name of the servlet. |

## Examples

### 1. Retrieving Initialization Parameters
**Example:**
```java
public void init(ServletConfig config) {
    String paramValue = config.getInitParameter("configParam");
    System.out.println("Initialization Parameter: " + paramValue);
}
```

### 2. Accessing the Servlet Context
**Example:**
```java
public void init(ServletConfig config) {
    ServletContext context = config.getServletContext();
    String appName = context.getInitParameter("applicationName");
    System.out.println("Application Name: " + appName);
}
```

### 3. Getting the Servlet Name
**Example:**
```java
public void init(ServletConfig config) {
    String servletName = config.getServletName();
    System.out.println("Servlet Name: " + servletName);
}
```

## Additional Notes
- `ServletConfig` is specific to a single servlet, while `ServletContext` is shared across the entire web application.
- Initialization parameters for a servlet are defined in the `web.xml` file under the `<init-param>` tag.

### Example `web.xml` Configuration
```xml
<servlet>
    <servlet-name>MyServlet</servlet-name>
    <servlet-class>com.example.MyServlet</servlet-class>
    <init-param>
        <param-name>configParam</param-name>
        <param-value>configValue</param-value>
    </init-param>
</servlet>
```

## Use Cases
- Configuring servlet-specific settings at deployment time.
- Accessing application-level parameters through the `ServletContext`.
- Differentiating servlets based on their initialization parameters.
