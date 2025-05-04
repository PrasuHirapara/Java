# UserDetailsService Documentation

## Introduction

- `UserDetailsService` is an interface in Spring Security responsible for fetching user-related data.
- It is used to retrieve user information, typically from a database, and provide it to the authentication process.
- The `loadUserByUsername` method is the core method used to retrieve user details based on a given username.
- The user details fetched via this service are wrapped in a `UserDetails` object, which is used during authentication and authorization.

---

## Method Summary

| Return Type      | Method Signature                                   | Description                                                                 |
|------------------|---------------------------------------------------|-----------------------------------------------------------------------------|
| `UserDetails`    | `loadUserByUsername(String username)`              | Loads the user details by username. This method is called during the authentication process. |
| `void`          | `setPasswordEncoder(PasswordEncoder passwordEncoder)` | Sets the password encoder to be used for encoding and verifying passwords. |
| `PasswordEncoder` | `getPasswordEncoder()`                             | Retrieves the password encoder used for encoding and verifying passwords. |

---

## Implementation
```java
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public CustomUserDetailsService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Retrieve user from the repository
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new User(userEntity.getUsername(), userEntity.getPassword(), new ArrayList<>());
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }
}
```

---

## Usage in Spring Boot Security Configuration

`UserDetailsService` is often used in the Spring Security configuration to authenticate users. Here’s how you can integrate it:
```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login")
                .permitAll();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```

In this configuration, the `UserDetailsService` is used to authenticate the user based on the username. A `PasswordEncoder` is configured to securely handle password verification. The `UserDetailsService` can be injected into your custom authentication filters as needed.