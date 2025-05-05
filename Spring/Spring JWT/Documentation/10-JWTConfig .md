## JWTConfig

### Introduction
- The `JWTConfig` class is responsible for configuring Spring Security with JWT-based authentication.
- It defines various security components such as filter chains, authentication manager, password encoder, and user details service.
- This configuration disables CSRF protection, adds custom JWT filters, and sets up authentication mechanisms to secure endpoints.
- The class integrates the JWT filter (`JwtAuthFilter`) to validate and authenticate requests using JWT tokens.

### Methods

| Return Type         | Method Name & Parameters                                       | Description                                                                                 |
|---------------------|---------------------------------------------------------------|---------------------------------------------------------------------------------------------|
| SecurityFilterChain  | `filterChain(HttpSecurity http)`                               | Configures HTTP security, disables CSRF, allows `/authenticate` endpoint to be accessed, and applies JWT filter to the filter chain. |
| UserDetailsService   | `userDetailsService()`                                         | Returns an implementation of `UserDetailsService` for loading user data, typically from a database. |
| PasswordEncoder      | `passwordEncoder()`                                            | Returns a password encoder for hashing and validating passwords.                            |
| AuthenticationManager| `authenticationManager(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder)` | Configures the `AuthenticationManager` to handle authentication using a `DaoAuthenticationProvider`. |

### Code Implementation

```java
package com.springjwt.config;

import com.springjwt.filters.JwtAuthFilter;
import com.springjwt.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class JWTConfig {

    @Autowired
    JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/authenticate").permitAll()
                                .anyRequest().authenticated()
                );

        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService,
                                                       PasswordEncoder passwordEncoder){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);

        return new ProviderManager(daoAuthenticationProvider);
    }
}
```

### Explanation

**filterChain(HttpSecurity http)**:
- This method configures the security filter chain.
- It disables CSRF protection.
- Permits access to the `/authenticate` endpoint without requiring authentication.
- Ensures that all other requests require authentication.
- Adds the custom `JwtAuthFilter` before the `UsernamePasswordAuthenticationFilter` in the filter chain.

**userDetailsService()**:
- This method returns a custom implementation of `UserDetailsService`.
- The `UserDetailsService` is responsible for loading user details, typically from a database.
- In this case, it returns the `CustomUserService` implementation.

**passwordEncoder()**:
- This method provides a `BCryptPasswordEncoder`.
- The encoder is used to encode passwords for storage and verify them during authentication.

**authenticationManager()**:
- This method configures the `AuthenticationManager`, which is responsible for authenticating the user.
- It uses a `DaoAuthenticationProvider` that delegates the authentication logic to a `UserDetailsService`.
- The `PasswordEncoder` is used to validate the password.
- The `AuthenticationManager` is created using a `ProviderManager` that manages this provider.
