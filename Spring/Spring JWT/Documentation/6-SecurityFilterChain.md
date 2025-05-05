## SecurityFilterChain

### Introduction

* Core component in Spring Security that defines how HTTP security is configured.
* Declared as a `@Bean` to customize security behavior across different endpoints.
* Manages filters, CSRF settings, session policies, and request authorizations.
* Responsible for plugging in custom filters like JWT authentication filter.
* Binds URL patterns to security rules.

### Methods

| Return Type         | Method Name & Parameters         | Description                                                                 |
| ------------------- | -------------------------------- | --------------------------------------------------------------------------- |
| SecurityFilterChain | `filterChain(HttpSecurity http)` | Configures HTTP security, authorizations, and adds JWT filter to the chain. |

### Code Implementation

```java
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
