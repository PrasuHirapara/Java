# Exception Handling
Exception handling in Spring Boot allows developers to gracefully manage errors in an application by providing structured mechanisms to handle exceptions. It improves user experience and helps in debugging by providing meaningful error responses.

## Advantages
1. **Improved User Experience**: Prevents application crashes by providing clear error messages.
2. **Centralized Error Management**: Simplifies debugging by handling exceptions in one place.
3. **Custom Responses**: Allows for tailored error messages and status codes.
4. **Enhanced Debugging**: Logs detailed error information for developers.
5. **Consistency**: Ensures uniform error handling across the application.

## Use Cases
1. Handling resource not found errors.
2. Validating user input.
3. Managing database exceptions.
4. Dealing with authentication and authorization issues.
5. Logging unexpected errors.

## Annotations

### 1. `@ExceptionHandler`
**Description**: Maps a specific exception to a handling method.
**Parameters**:
- `value`: The exception classes to handle (e.g., `DepartmentNotFound.class`).
- `name`: The name of the exception handler.

### 2. `@ControllerAdvice`
**Description**: Defines global exception handling for controllers.
**Parameters**:
- `basePackages`: Specifies the packages to apply the advice to.
- `basePackageClasses`: Specifies classes within the base package for the advice to apply to.
- `annotations`: Specifies annotations that controllers should have for the advice to apply.

### 3. `@ResponseStatus`
**Description**: Sets the HTTP status code for a specific exception.
**Parameters**:
- `value`: HTTP status (e.g., `HttpStatus.NOT_FOUND`).
- `reason`: A reason phrase for the status.
- `code`: Alternative parameter for HTTP status, used in some versions.

### 4. `@RestControllerAdvice`
**Description**: Combines `@ControllerAdvice` and `@ResponseBody` for REST APIs.

## Example Code

### Custom Exception Class
```java
package prasu.Error;

public class DepartmentNotFound extends RuntimeException {
    public DepartmentNotFound(String message) {
        super(message);
    }
}
```

### Entity Class for Error Messages
```java
package prasu.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private HttpStatus status;
    private String message;
}
```

### Service Method
```java
@Override
public Department fetchDepartmentById(Long id) throws DepartmentNotFound {
    Optional<Department> department = departmentRepository.findById(id);

    if (!department.isPresent()) {
        throw new DepartmentNotFound("Department not found exception.");
    }

    return department.get();
}
```

### Exception Handler Class
```java
package prasu.Error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import prasu.Entity.ErrorMessage;

@ControllerAdvice(basePackages = "prasu", annotations = RestController.class)
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DepartmentNotFound.class)
    public ResponseEntity<ErrorMessage> departmentNotFoundException(
            DepartmentNotFound exception,
            WebRequest request
    ) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorMessage);
    }
}
```

### Conclusion
This structured approach ensures proper exception handling in Spring Boot applications with meaningful and consistent responses.
