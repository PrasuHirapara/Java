# UserDetailsService Interface in Spring Security

## Introduction
The `UserDetailsService` interface in Spring Security is a core component for loading user-specific data during the authentication process. It provides a single method, `loadUserByUsername(String username)`, to retrieve user details from a persistent storage or other systems.

---

## Methods in UserDetailsService Interface

- `UserDetails loadUserByUsername(String username)` - Loads the user information by the provided username and returns a `UserDetails` object.

---

## Example Implementation
```java
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final Map<String, UserDetails> users = new HashMap<>();

    static {
        users.put("user1", User.builder()
            .username("user1")
            .password("password1")
            .roles("USER")
            .build());

        users.put("admin", User.builder()
            .username("admin")
            .password("adminpass")
            .roles("ADMIN")
            .build());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!users.containsKey(username)) {
            throw new UsernameNotFoundException("User not found: " + username);
        }
        return users.get(username);
    }
}
```

---

## Use Cases

1. **Custom Authentication**: Retrieve user details from databases, LDAP, or other external systems for authentication.
2. **Role-Based Security**: Enforce role-based access control by associating roles with user details.
3. **Integration with OAuth2**: Extend the `UserDetailsService` to integrate with OAuth2 authorization.
4. **Enhanced Security Features**: Store additional attributes (e.g., account status, permissions) with user details.

---

## Conclusion
The `UserDetailsService` interface is a fundamental part of Spring Security, offering a mechanism to load user-specific data for authentication. Its simplicity and flexibility make it suitable for a wide range of applications, from simple in-memory authentication to complex database-backed systems.
