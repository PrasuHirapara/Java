# Security Filter Chain

## Introduction
The **Security Filter Chain** is a core component of Spring Security that handles the filtering and processing of HTTP requests for authentication, authorization, and other security-related tasks. Each request passes through a chain of security filters before being processed by the application.

---

## Key Components of the Security Filter Chain
1. **HttpSecurity**: Used to define the configuration of the security filter chain.
2. **Filters**: A series of filters, each with a specific responsibility, e.g., authentication, CSRF protection, session management.
3. **Order**: The filters execute in a predefined sequence.

---

## Configuration of Security Filter Chain
To configure a custom security filter chain in Spring Security, you can define a `SecurityFilterChain` bean in a `@Configuration` class.

### Example:
```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF for simplicity (not recommended for production)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/public/**").permitAll() // Public endpoints
                .anyRequest().authenticated()             // Secure all other endpoints
            )
            .httpBasic(); // Enable basic authentication

        return http.build();
    }
}
```

---

## Common Filters in Spring Security Filter Chain

### 1. **UsernamePasswordAuthenticationFilter**
- Handles authentication for username and password-based logins.

### 2. **SecurityContextPersistenceFilter**
- Persists the `SecurityContext` between requests.

### 3. **ExceptionTranslationFilter**
- Handles exceptions during authentication and authorization.

### 4. **CsrfFilter**
- Provides protection against Cross-Site Request Forgery (CSRF) attacks.

### 5. **LogoutFilter**
- Handles logout functionality.

### 6. **SessionManagementFilter**
- Manages user sessions and ensures session policies are enforced.

---

## Advantages of Security Filter Chain
- **Customizable**: Configure filters as needed for your application.
- **Extensible**: Add custom filters to the chain.
- **Declarative**: Use annotations and configuration classes for security setup.

---

## Adding Custom Filters
Custom filters can be added to the security filter chain using the `addFilterBefore` or `addFilterAfter` methods.

### Example:
```java
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeHttpRequests(auth -> auth
                .anyRequest().authenticated()
            )
            .addFilterBefore(new CustomFilter(), UsernamePasswordAuthenticationFilter.class); // Add custom filter

        return http.build();
    }
}
```

### Custom Filter Implementation:
```java
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class CustomFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Custom filter logic
        System.out.println("Custom filter executed for request: " + request.getRequestURI());
        filterChain.doFilter(request, response);
    }
}
```

---

## Methods in Security Configuration

### SecurityConfig Class Methods
1. `SecurityFilterChain build()` - Returns the configured SecurityFilterChain.
2. `HttpSecurity csrf()` - Returns the CSRF configuration for the HttpSecurity object.
3. `HttpSecurity authorizeHttpRequests()` - Configures authorization rules for requests.
4. `HttpSecurity httpBasic()` - Enables HTTP Basic Authentication.
5. `HttpSecurity addFilterBefore(Filter filter, Class<? extends Filter> beforeFilter)` - Adds a custom filter before another filter.

### CustomFilter Class Methods
1. `void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)` - Executes the custom filter logic.

---

## Debugging the Security Filter Chain
To debug and view the security filter chain, enable debugging logs for Spring Security:
```properties
logging.level.org.springframework.security=DEBUG
```

---

## Conclusion
The **Security Filter Chain** is a powerful and flexible mechanism in Spring Security for securing web applications. By understanding its components and configuration, developers can build secure and robust applications.
