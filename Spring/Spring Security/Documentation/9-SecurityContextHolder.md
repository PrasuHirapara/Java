# SecurityContextHolder Documentation

## Introduction

- `SecurityContextHolder` is a core class in Spring Security.
- It is used to hold the `SecurityContext` which contains the `Authentication` object for the current thread of execution.
- The `SecurityContext` is used throughout the application to retrieve authentication details such as the authenticated user and their roles.
- `SecurityContextHolder` ensures that security information is available within the context of the current request, supporting thread-local storage.

---

## Method Summary

| Return Type | Method Signature | Description |
|-------------|------------------|-------------|
| `SecurityContext` | `getContext()` | Returns the `SecurityContext` for the current thread of execution. |
| `void` | `setContext(SecurityContext context)` | Sets the `SecurityContext` for the current thread of execution. |
| `void` | `clearContext()` | Clears the `SecurityContext` for the current thread, effectively logging out the user. |
| `SecurityContext` | `createEmptyContext()` | Creates a new empty `SecurityContext`. |
| `SecurityContext` | `getContext(SecurityContext context)` | Returns the `SecurityContext` for the current thread, or the specified one if provided. |

---

## Implementation

```java
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class CustomSecurityContextHolder {

    public static void main(String[] args) {
        // Setting a custom SecurityContext
        SecurityContextHolder.setContext(createCustomContext());

        // Retrieving the current SecurityContext
        SecurityContext context = SecurityContextHolder.getContext();
        System.out.println("Current Authentication: " + context.getAuthentication().getName());

        // Clearing the SecurityContext
        SecurityContextHolder.clearContext();
        System.out.println("SecurityContext cleared.");
    }

    // Example method to create a custom SecurityContext
    private static SecurityContext createCustomContext() {
        // Here, you can create a custom authentication and set it into the context
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(new CustomAuthentication("testUser", "password", true, Collections.emptyList()));
        return context;
    }
}

class CustomAuthentication implements Authentication {

    private final String username;
    private final String password;
    private final boolean isAuthenticated;
    private final Collection<? extends GrantedAuthority> authorities;

    public CustomAuthentication(String username, String password, boolean isAuthenticated, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.isAuthenticated = isAuthenticated;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return password;
    }

    @Override
    public Object getDetails() {
        return null; // Custom details can be added if necessary
    }

    @Override
    public String getName() {
        return username;
    }

    @Override
    public Object getPrincipal() {
        return username; // The principal could be the user object
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.isAuthenticated = isAuthenticated;
    }
}
```