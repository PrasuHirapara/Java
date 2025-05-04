# Authentication Documentation

## Introduction

- `Authentication` is a core interface in Spring Security.
- Represents the authentication information of a user.
- It holds user details, roles, and authorities granted after successful authentication.
- Commonly used by various components like filters, managers, and providers in Spring Security.

---

## Method Summary

| Return Type                      | Method Signature                                                      | Description                                                                 |
|----------------------------------|------------------------------------------------------------------------|-----------------------------------------------------------------------------|
| `Collection<? extends GrantedAuthority>` | `getAuthorities()`                                                     | Returns a collection of granted authorities or roles for the authenticated user. |
| `Object`                         | `getCredentials()`                                                     | Returns the credentials (usually a password) of the authenticated user.    |
| `Object`                         | `getDetails()`                                                         | Returns any additional details (like session or authentication metadata).  |
| `String`                         | `getName()`                                                            | Returns the principal (username or user identifier) for the authenticated user. |
| `Object`                         | `getPrincipal()`                                                       | Returns the principal (usually the user object) representing the authenticated user. |
| `boolean`                        | `isAuthenticated()`                                                    | Returns whether the user is authenticated or not.                          |
| `void`                           | `setAuthenticated(boolean isAuthenticated)`                            | Sets the authentication status of the user.                               |

---

## Implementation

```java
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collection;
import java.util.Collections;

public class CustomAuthentication implements Authentication {

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