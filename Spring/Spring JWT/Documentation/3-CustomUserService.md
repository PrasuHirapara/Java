## UserDetailsService

### Introduction

* Core interface in Spring Security for retrieving user-related data.
* Used by `DaoAuthenticationProvider` during the authentication process.
* Provides a single method to load a user based on username.
* Implementation must return a fully populated `UserDetails` object.

### Methods

| Return Type | Method Name & Parameters              | Description                                                          |
| ----------- | ------------------------------------- | -------------------------------------------------------------------- |
| UserDetails | `loadUserByUsername(String username)` | Loads user-specific data by username. Throws exception if not found. |

### Code Implementation

```java
@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User name not found"));
    }
}
```

* `CustomUserService` implements `UserDetailsService`.
* It uses `UserRepository` to fetch user data from the database.
* If the user is found, it returns an instance of `Users` which implements `UserDetails`.
* If not found, it throws a `UsernameNotFoundException`.
* This service is injected into the `DaoAuthenticationProvider` to support credential verification.
