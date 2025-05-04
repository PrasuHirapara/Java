# Security Configuration in Spring Boot

The `SecurityConfig` class configures security settings for a Spring Boot application using Spring Security.

1. Spring Security provides comprehensive security services for Java applications.
2. It handles authentication and authorization using configuration classes.
3. This configuration defines role-based access controls and custom login/logout handling.
4. Passwords are encoded using BCrypt for better security.
5. Remember-me and session management are included for user convenience and session integrity.

---

## Dependencies

Add Spring Security to your `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```
---

## Security Configuration Class

```java
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private final UserDetailsService userDetailsService;

    // Inject UserDetailsService to manage user details
    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // Publicly accessible URLs
                .antMatchers("/login", "/register", "/public/**").permitAll()
                // Accessible only to users with ADMIN role
                .antMatchers("/admin/**").hasRole("ADMIN")
                // Accessible to users with USER or ADMIN roles
                .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                // All other requests need authentication
                .anyRequest().authenticated()
                .and()
                .formLogin()
                // Custom login page and processing URL
                .loginPage("/login")
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/home", true)
                .failureUrl("/login?error=true")
                .permitAll()
                .and()
                .logout()
                // Custom logout settings
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and()
                .rememberMe()
                // Remember-me settings
                .tokenValiditySeconds(86400)
                .key("uniqueAndSecret")
                .and()
                // CSRF disabled (enable in production unless API-based)
                .csrf().disable();
    }

    // Bean for AuthenticationManager
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // Bean for password encoding
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```

---

## Explanation of Key Methods

* `authorizeRequests()`: Configures URL access rules.

    * `.permitAll()`: Allows access to specified paths.
    * `.hasRole("ADMIN")`: Requires the ADMIN role.
    * `.hasAnyRole("USER", "ADMIN")`: Requires USER or ADMIN role.
    * `.authenticated()`: Requires login for all other requests.

* `formLogin()`: Configures custom login flow.

    * `loginPage()`: Sets custom login page.
    * `loginProcessingUrl()`: Handles login form submission.
    * `defaultSuccessUrl()`: Where to go after login success.
    * `failureUrl()`: Redirects on login failure.

* `logout()`: Manages logout behavior.

    * `logoutSuccessUrl()`: Redirects after logout.
    * `invalidateHttpSession(true)`: Ends session.
    * `deleteCookies("JSESSIONID")`: Clears session cookies.

* `rememberMe()`: Enables remember-me cookies.

    * `tokenValiditySeconds(86400)`: 24 hours.
    * `key("uniqueAndSecret")`: A secret key to secure tokens.

* `csrf().disable()`: Disables CSRF protection (only if necessary).

---

## Example Usage in application.properties

```properties
spring.security.user.name=admin
spring.security.user.password=adminpassword
```

---

## Summary

* Public access: `/login`, `/register`, `/public/**`
* Admin access: `/admin/**`
* Authenticated users: `/user/**` and others
* Custom login/logout with session & cookie handling
* Optional remember-me login for 24 hours

This configuration secures your Spring Boot app with role-based access and customizable login/logout flows.
