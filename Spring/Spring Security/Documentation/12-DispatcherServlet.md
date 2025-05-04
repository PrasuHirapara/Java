## DispatcherServlet & Controller Handling

### DispatcherServlet

#### Introduction

* Core component of Spring Web MVC architecture.
* Acts as the **front controller** that intercepts all incoming HTTP requests.
* Delegates the requests to appropriate handler components such as controllers.
* Configurable via `web.xml` or programmatic configuration (e.g., `WebApplicationInitializer`).
* Part of the `org.springframework.web.servlet` package.

#### Responsibilities

* Maps HTTP requests to handler methods using `HandlerMapping`.
* Executes the selected handler via `HandlerAdapter`.
* Resolves the view name returned by the handler using `ViewResolver`.
* Renders the view (e.g., JSP, Thymeleaf, JSON) and sends it to the client.

#### Lifecycle Methods

| Return Type | Method & Parameters                                           | Description                                                         |
| ----------- | ------------------------------------------------------------- | ------------------------------------------------------------------- |
| void        | `init()`                                                      | Initializes internal strategies like HandlerMapping, etc.           |
| void        | `doService(HttpServletRequest req, HttpServletResponse res)`  | Main request processing logic, dispatches to `doDispatch()`.        |
| void        | `doDispatch(HttpServletRequest req, HttpServletResponse res)` | Delegates request to handler, processes ModelAndView, renders view. |

#### Configuration Example

```xml
<servlet>
    <servlet-name>spring</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
</servlet>

<servlet-mapping>
    <servlet-name>spring</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping>
```

---

### Controller Handling

#### Introduction

* Spring MVC controllers are responsible for processing business logic and returning responses.
* Annotated with `@Controller` or `@RestController`.
* Methods inside controllers are mapped to request paths via `@RequestMapping`, `@GetMapping`, `@PostMapping`, etc.
* Return values are handled by `ViewResolvers` or converted to HTTP responses (e.g., JSON in REST APIs).

#### Key Annotations

| Annotation        | Purpose                                                      |
| ----------------- | ------------------------------------------------------------ |
| `@Controller`     | Declares a Spring MVC controller class.                      |
| `@RestController` | Shortcut for `@Controller + @ResponseBody` (for REST APIs).  |
| `@RequestMapping` | Maps HTTP requests to handler methods.                       |
| `@GetMapping`     | Shortcut for `@RequestMapping(method = RequestMethod.GET)`.  |
| `@PostMapping`    | Shortcut for `@RequestMapping(method = RequestMethod.POST)`. |
| `@ResponseBody`   | Indicates that return value is the response body itself.     |

#### Example Controller

```java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to Spring MVC!");
        return "home"; // View name
    }
}
```

#### REST Example

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/api/greeting")
    public String greet() {
        return "Hello, REST!";
    }
}
```

---

### Summary

* `DispatcherServlet` is the central dispatcher in Spring MVC.
* It coordinates with handlers, views, and resolvers.
* Controllers contain the business logic and return either views or direct responses.
* Together, they form the core of Spring Web MVC's request handling mechanism.
