## AuthenticationManager

### Introduction

* Core interface in Spring Security for authenticating user credentials.
* Used to delegate authentication requests to configured `AuthenticationProvider` implementations.
* In JWT-based systems, often wired into the login controller to validate credentials and issue tokens.
* Decouples authentication logic from the controller or endpoint logic.
* Usually configured using `ProviderManager` in Spring Security configuration.

### Methods

| Return Type      | Method Name & Parameters                      | Description                                                                                 |
| ---------------- | --------------------------------------------- | ------------------------------------------------------------------------------------------- |
| `Authentication` | `authenticate(Authentication authentication)` | Authenticates the given credentials and returns a fully authenticated object if successful. |

### Code Implementation

```java
package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;

import java.util.List;

@Configuration
public class JWTConfig {

    private final AuthenticationProvider authenticationProvider;

    public JWTConfig(AuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(List.of(authenticationProvider));
    }
}
```

### Usage Example

```java
package com.example.security.controller;

import com.example.security.dto.AuthRequest;
import com.example.security.service.JWTUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public String authenticate(@RequestBody AuthRequest authRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    authRequest.getUsername(),
                    authRequest.getPassword()
                )
            );
            return jwtUtil.generateToken(authRequest.getUsername());
        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
```
