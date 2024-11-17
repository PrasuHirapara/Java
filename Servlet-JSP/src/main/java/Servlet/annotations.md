
# Servlet Annotations in Java

## 1. `@WebServlet`
- **Definition**: Maps a Servlet to a specific URL. This defines where the Servlet listens for requests and can only be applied to a class.
- **Example on Class**:
  ```java
  @WebServlet("/example") // This Servlet will respond to requests at the "/example" URL.
  public class ExampleServlet extends HttpServlet {
      @Override
      protected void doGet(HttpServletRequest request, HttpServletResponse response) { 
          // This method will handle GET requests made to "/example".
      }
  }
  ```
### Or Configure `web.xml`
- Instead of using annotations, you can define the mapping in the web.xml file

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee https://jakarta.ee/xml/ns/jakartaee/web-app_6_0.xsd"
         version="6.0">

  <servlet>
    <servlet-name>SumOfNumServlet</servlet-name>
    <servlet-class>SumOfNum</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>SumOfNumServlet</servlet-name>
    <url-pattern>/add</url-pattern>
  </servlet-mapping>

</web-app>

```

## 2. `@WebFilter`
- **Definition**: Declares a filter that intercepts requests or responses for specified URLs or Servlets. Only applied to classes.
- **Example on Class**:
  ```java
  @WebFilter("/exampleFilter") // This Filter intercepts requests going to "/exampleFilter".
  public class ExampleFilter implements Filter {
      @Override
      public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) { 
          // This method will process requests before passing them on, or responses after receiving them.
      }
  }
  ```

## 3. `@WebListener`
- **Definition**: Registers a listener to monitor lifecycle events like start and stop for ServletContext, HttpSession, or ServletRequest.
- **Example on Class**:
  ```java
  @WebListener // This Listener reacts to lifecycle events of ServletContext, HttpSession, or ServletRequest.
  public class ExampleListener implements ServletContextListener {
      @Override
      public void contextInitialized(ServletContextEvent sce) { 
          // This method is called when the ServletContext is initialized.
      }
  }
  ```

## 4. `@MultipartConfig`
- **Definition**: Sets up a Servlet to handle file uploads in multipart requests, often used for processing forms with file inputs.
- **Example on Class**:
  ```java
  @WebServlet("/upload")
  @MultipartConfig // Enables this Servlet to handle multipart requests for file uploads.
  public class FileUploadServlet extends HttpServlet {
      @Override
      protected void doPost(HttpServletRequest request, HttpServletResponse response) { 
          // This method will process file uploads submitted in POST requests.
      }
  }
  ```

## 5. `@ServletSecurity`
- **Definition**: Specifies security rules, like role-based access, for the Servlet. Can be applied to methods or classes.
- **Example on Method**:
  ```java
  @WebServlet("/secure")
  public class SecureServlet extends HttpServlet {
      @ServletSecurity(@HttpConstraint(rolesAllowed = "ADMIN"))
      @Override
      protected void doGet(HttpServletRequest request, HttpServletResponse response) { 
          // This method will allow access only to users in the "ADMIN" role.
      }
  }
  ```

## 6. `@HttpConstraint`
- **Definition**: Sets constraints for roles that are allowed to access specific HTTP methods within `@ServletSecurity`.
- **Example on Method**:
  ```java
  @WebServlet("/admin")
  @ServletSecurity(@HttpConstraint(rolesAllowed = "ADMIN"))
  public class AdminServlet extends HttpServlet {
      @Override
      protected void doPost(HttpServletRequest request, HttpServletResponse response) { 
          // This POST method will be accessible only to "ADMIN" role users.
      }
  }
  ```

## 7. `@HttpMethodConstraint`
- **Definition**: Applies constraints for specific HTTP methods (e.g., POST) within `@ServletSecurity`, useful for role-based access control.
- **Example on Method**:
  ```java
  @WebServlet("/submit")
  @ServletSecurity(httpMethodConstraints = {@HttpMethodConstraint(value = "POST", rolesAllowed = "USER")})
  public class SubmitServlet extends HttpServlet {
      @Override
      protected void doPost(HttpServletRequest request, HttpServletResponse response) { 
          // Only users with the "USER" role can access this POST method.
      }
  }
  ```

## 8. `@RunAs`
- **Definition**: Specifies the role under which a Servlet class runs, enabling role-based access configurations.
- **Example on Class**:
  ```java
  @WebServlet("/adminTask")
  @RunAs("ADMIN") // This Servlet will run with "ADMIN" role permissions.
  public class AdminTaskServlet extends HttpServlet {
      @Override
      protected void doGet(HttpServletRequest request, HttpServletResponse response) { 
          // This GET method will execute with "ADMIN" privileges.
      }
  }
  ```

## 9. `@HandlesTypes`
- **Definition**: Declares specific types (classes or interfaces) that can be discovered at container startup for initialization.
- **Example on Class**:
  ```java
  @HandlesTypes(MyApplication.class) // Container initializes classes implementing MyApplication interface.
  public class AppInitializer implements ServletContainerInitializer {
      @Override
      public void onStartup(Set<Class<?>> c, ServletContext ctx) { 
          // This method is called at startup with discovered classes.
      }
  }
  ```

## 10. `@WebInitParam`
- **Definition**: Sets up initialization parameters for Servlets or Filters, defining key-value pairs used in configuration.
- **Example on Class**:
  ```java
  @WebServlet(urlPatterns = "/config", initParams = {@WebInitParam(name = "config", value = "initValue")})
  public class ConfigServlet extends HttpServlet {
      @Override
      public void init() { 
          // Initialization parameters can be accessed here.
      }
  }
  ```

## 11. `@PreDestroy`
- **Definition**: Marks a method to be called just before a Servlet instance is destroyed, allowing cleanup activities.
- **Example on Method**:
  ```java
  @WebServlet("/cleanup")
  public class CleanupServlet extends HttpServlet {
      @PreDestroy // This method will be called before the Servlet instance is destroyed.
      public void cleanup() { 
          // Cleanup resources before the instance is terminated.
      }
  }
  ```

## 12. `@PostConstruct`
- **Definition**: Defines a method to be called after Servlet initialization, often for resource setup.
- **Example on Method**:
  ```java
  @WebServlet("/init")
  public class InitServlet extends HttpServlet {
      @PostConstruct // This method is called after the Servlet instance is created.
      public void initResources() { 
          // Initialize resources needed for the Servlet.
      }
  }
  ```

## 13. `@Resource`
- **Definition**: Injects resources like a DataSource or environment entry, used on variables.
- **Example on Variable**:
  ```java
  @WebServlet("/datasource")
  public class DataSourceServlet extends HttpServlet {
      @Resource(name = "jdbc/mydb") // Injects a DataSource resource named "jdbc/mydb".
      private DataSource ds;
  }
  ```

## 14. `@EJB`
- **Definition**: Injects an Enterprise JavaBean (EJB) instance, usually on a variable in Servlets for business logic.
- **Example on Variable**:
  ```java
  @WebServlet("/service")
  public class ServiceServlet extends HttpServlet {
      @EJB // Injects the MyService EJB instance.
      private MyService service;
  }
  ```

## 15. `@PersistenceContext`
- **Definition**: Injects an EntityManager for JPA, enabling database operations within a Servlet.
- **Example on Variable**:
  ```java
  @WebServlet("/persist")
  public class PersistServlet extends HttpServlet {
      @PersistenceContext // Injects an EntityManager instance for database operations.
      private EntityManager em;
  }
  ```
---