## DaoAuthenticationProvider

### Introduction

* Part of Spring Security's authentication mechanism.
* Implements `AuthenticationProvider`.
* Responsible for validating `UsernamePasswordAuthenticationToken`.
* Uses a `UserDetailsService` to retrieve user information.
* Applies `PasswordEncoder` to match raw and stored passwords.

### Methods

| Return Type    | Method Name & Parameters                            | Description                                                             |
| -------------- | --------------------------------------------------- | ----------------------------------------------------------------------- |
| void           | `setUserDetailsService(UserDetailsService service)` | Sets the custom `UserDetailsService` used for loading user data.        |
| void           | `setPasswordEncoder(PasswordEncoder encoder)`       | Configures the encoder used to match passwords.                         |
| Authentication | `authenticate(Authentication authentication)`       | Performs authentication with the provided `Authentication` object.      |
| boolean        | `supports(Class<?> authentication)`                 | Indicates whether this provider supports the given authentication type. |

### Code Implementation

```java
@Bean
public AuthenticationManager authenticationManager(UserDetailsService userDetailsService,
                                                   PasswordEncoder passwordEncoder) {
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setUserDetailsService(userDetailsService);
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);

    return new ProviderManager(daoAuthenticationProvider);
}
```

* `DaoAuthenticationProvider` is used in the Spring context to handle the authentication process.
* It interacts with a custom `UserDetailsService` and uses a `BCryptPasswordEncoder` to compare passwords.
* This setup allows the `AuthenticationManager` to delegate to the `DaoAuthenticationProvider` during login.
