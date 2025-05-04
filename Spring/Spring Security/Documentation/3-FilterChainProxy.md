# FilterChainProxy in Spring Security

## Introduction

`FilterChainProxy` is a fundamental class in Spring Security that acts as the main entry point for delegating incoming HTTP requests to one or more security filter chains (`SecurityFilterChain`). It implements the `javax.servlet.Filter` interface and is registered in the web application's filter chain.

It is responsible for managing and delegating HTTP request processing to appropriate `SecurityFilterChain` instances based on URL pattern matching.

---

## Key Components

* **Class:** `org.springframework.security.web.FilterChainProxy`
* **Interface Implemented:** `javax.servlet.Filter`
* **Purpose:** Delegates incoming HTTP requests to one or more `SecurityFilterChain` implementations based on URL patterns.
* **Usage:** Automatically registered by Spring Boot when using `spring-boot-starter-security`, but can also be manually configured.

---

## Main Methods in `FilterChainProxy`

| Return Type               | Method Signature                                                                                | Description                                                                        |
| ------------------------- | ----------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- |
| void                      | `doFilter(ServletRequest request, ServletResponse response, FilterChain chain)`                 | Entry point for the filter chain; delegates to the matching `SecurityFilterChain`. |
| List<SecurityFilterChain> | `getFilterChains()`                                                                             | Returns the list of configured `SecurityFilterChain` instances.                    |
| void                      | `doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)` | Internal filter delegation logic; used by `doFilter`.                              |
| void                      | `init(FilterConfig filterConfig)`                                                               | Initialization method from the Filter interface.                                   |
| void                      | `destroy()`                                                                                     | Cleanup method from the Filter interface.                                          |

---

## Code Implementation Using `FilterChainProxy`

This is an example of creating a custom `FilterChainProxy` configuration in a Spring Boot 3.x application.

```java
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.FilterChainProxy;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Configuration
public class CustomSecurityFilterChainProxyConfig {

    @Bean
    public FilterChainProxy filterChainProxy(SecurityFilterChain publicChain,
                                             SecurityFilterChain adminChain,
                                             SecurityFilterChain defaultChain) {
        // Order matters: first matching chain is used
        return new FilterChainProxy(List.of(publicChain, adminChain, defaultChain));
    }

    @Bean
    public SecurityFilterChain publicChain(HttpSecurity http) throws Exception {
        http
            .securityMatcher(new AntPathRequestMatcher("/public/**"))
            .authorizeHttpRequests(authz -> authz
                .anyRequest().permitAll()
            );
        return http.build();
    }

    @Bean
    public SecurityFilterChain adminChain(HttpSecurity http) throws Exception {
        http
            .securityMatcher(new AntPathRequestMatcher("/admin/**"))
            .authorizeHttpRequests(authz -> authz
                .anyRequest().hasRole("ADMIN")
            );
        return http.build();
    }

    @Bean
    public SecurityFilterChain defaultChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .anyRequest().authenticated()
            )
            .formLogin(withDefaults());
        return http.build();
    }
}
```

---

## Summary

* `FilterChainProxy` is central to how Spring Security handles HTTP filtering.
* It delegates requests to configured `SecurityFilterChain`s based on URL pattern matchers.
* It implements the standard `Filter` interface and integrates cleanly with the servlet container.
* You can customize the behavior by creating your own beans of `SecurityFilterChain` and injecting them into a `FilterChainProxy` bean.

Let me know if you want a diagram or visual representation of how filter delegation works.
