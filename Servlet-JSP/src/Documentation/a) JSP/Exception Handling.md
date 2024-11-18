
# Exception Handling in JSP

Exception handling in JSP is crucial for building robust web applications. JSP provides mechanisms to handle both runtime and application-specific exceptions.

## Methods for Exception Handling

1. **Using `isErrorPage` and `errorPage` Attributes**:
    - **`isErrorPage="true"`**: Indicates that a JSP is an error page that handles exceptions.
    - **`errorPage="example.jsp"` Attribute**: Specifies a JSP to redirect to when an exception occurs.

2. **Using `try-catch` Blocks in Scriptlets**:
    - Embedding `try-catch` blocks within JSP to handle exceptions locally.

3. **Defining Custom Error Pages in `web.xml`**:
    - Configuring error pages for specific HTTP error codes or exception types.

---

## Rules for Exception Handling

1. A JSP designated as an error page must have `isErrorPage="true"` set.
2. The `exception` implicit object is only available in JSPs with `isErrorPage="true"`.
3. Use `errorPage="example.jsp"` in a JSP to redirect unhandled exceptions to a specified error-handling JSP.
4. Avoid exposing stack traces to end-users for security reasons.
5. Utilize `web.xml` for centralized error handling.

---

## Example: Handling `ArithmeticException`

### Main JSP File (`main.jsp`)
```jsp
<%@ page errorPage="error.jsp" %>
<%
    int result = 10 / 0; // This will cause ArithmeticException
%>
```

### Error Page (`error.jsp`)
```jsp
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Error Handling</title>
</head>
<body>
    <h2>An error occurred:</h2>
    <p><strong>Exception:</strong> <%= exception.getClass().getName() %></p>
    <p><strong>Message:</strong> <%= exception.getMessage() %></p>
</body>
</html>
```

---

## Defining Custom Error Pages in `web.xml`

```xml
<error-page>
    <exception-type>java.lang.ArithmeticException</exception-type>
    <location>/error.jsp</location>
</error-page>
```

---

## Explanation of Example

1. **Triggering the Exception**:
    - In `main.jsp`, dividing by zero triggers an `ArithmeticException`.
    - The `errorPage` attribute redirects the request to `error.jsp`.

2. **Displaying Error Information**:
    - `error.jsp` displays the exception type and message using the `exception` object.

3. **Centralized Configuration**:
    - The `web.xml` file ensures all `ArithmeticException` instances are directed to the error page.

---

## Best Practices

- Always define a generic error page for unexpected issues.
- Separate technical error details from user-facing error messages.
- Log errors for debugging while showing user-friendly messages to end-users.
