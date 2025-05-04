# Spring Boot Controllers

In Spring Boot, controllers play a crucial role in handling HTTP requests and defining the application's endpoints. Controllers are annotated classes that contain methods mapped to specific HTTP requests (e.g., GET, POST). These methods process incoming requests, execute business logic, and return responses.

---

## Key Concepts of Spring Boot Controllers

1. **Separation of Concerns**:
   - Controllers act as the intermediary between the client and the service layer, ensuring a clean separation of business logic and presentation logic.

2. **Annotation-Based Configuration**:
   - Spring Boot controllers rely on annotations for mapping requests and defining behaviors.

3. **RESTful APIs**:
   - Controllers are widely used to build RESTful APIs in Spring Boot.

4. **Request Mapping**:
   - Methods in controllers are mapped to specific HTTP verbs and URL patterns using annotations.

---

## Key Annotations Used in Controllers

### 1. `@Component`
- Marks a class as a Spring-managed component.
- Enables Spring to detect and register the class as a bean.

### 2. `@Controller`
- Indicates that a class is a Spring MVC controller.
- Typically used to define endpoints for web applications that return views (e.g., JSP, Thymeleaf).

### 3. `@RestController`
- Combines `@Controller` and `@ResponseBody`.
- Indicates that a class is a RESTful controller, and all methods return JSON or XML responses by default.

### 4. `@RequestMapping`
- Maps HTTP requests to specific classes or methods.
- Can be used at the class or method level.

Example:
```java
@RequestMapping("/api")
public class MyController {
    @RequestMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}
```

### 5. `@GetMapping`
- Maps HTTP GET requests to a specific method.

### 6. `@PostMapping`
- Maps HTTP POST requests to a specific method.

### 7. `@PutMapping`
- Maps HTTP PUT requests to a specific method.

### 8. `@DeleteMapping`
- Maps HTTP DELETE requests to a specific method.

### 9. `@PathVariable`
- Binds a method parameter to a URI template variable.

Example:
```java
@GetMapping("/user/{id}")
public String getUserById(@PathVariable("id") String userId) {
    return "User ID: " + userId;
}
```

### 10. `@RequestParam`
- Binds a method parameter to a query parameter in the request.

Example:
```java
@GetMapping("/search")
public String search(@RequestParam("q") String query) {
    return "Searching for: " + query;
}
```

### 11. `@RequestBody`
- Maps the body of the HTTP request to a Java object and performs automatic deserialization.

### 12. `@ResponseStatus`
- Specifies the HTTP status code for a method's response.

### 13. Validation Annotations
- **`@Valid`**: Used for validating objects.
- **`@NotNull`**: Ensures a field is not null.
- **`@Size(min, max)`**: Specifies size constraints for a field.
- **`@Email`**: Validates email format.
- **`@Positive`**: Ensures a number is positive.
- **`@PositiveOrZero`**: Ensures a number is zero or positive.
- **`@Negative`**: Ensures a number is negative.
- **`@NegativeOrZero`**: Ensures a number is zero or negative.
- **`@Future`**: Ensures a date is in the future.
- **`@FutureOrPresent`**: Ensures a date is in the present or future.

Example:
```java
public class User {
    @NotNull
    private String name;

    @Size(min = 1, max = 20)
    private String username;

    @Email
    private String email;

    @Positive
    private int age;
}
```

---

## Writing a Controller in Spring Boot

### Example: Simple REST Controller

**1. Define the Controller**

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Boot!";
    }
}
```

**2. Run the Application**

- Access the endpoint by starting the Spring Boot application and navigating to `http://localhost:8080/hello`.

---

## Best Practices for Controllers

1. **Keep Controllers Lightweight**:
   - Limit controllers to request-handling logic. Delegate business logic to service classes.

2. **Use Meaningful Annotations**:
   - Prefer `@GetMapping`, `@PostMapping`, etc., over generic `@RequestMapping` for readability.

3. **Return Standard Responses**:
   - Use `ResponseEntity` for better control over HTTP status codes and response headers.

4. **Handle Exceptions Gracefully**:
   - Implement exception handling using `@ControllerAdvice` and `@ExceptionHandler`.

5. **Validate Input**:
   - Use annotations like `@Valid` and `@RequestBody` to validate incoming data.

6. **Document APIs**:
   - Use tools like Swagger or OpenAPI to generate API documentation.

---

## Conclusion

Spring Boot controllers are the backbone of web and RESTful applications. By leveraging the rich set of annotations and following best practices, developers can efficiently handle HTTP requests, build clean APIs, and maintain a well-structured codebase.
