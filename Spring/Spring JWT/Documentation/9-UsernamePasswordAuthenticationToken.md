## UsernamePasswordAuthenticationToken

### Introduction
- Represents an authentication token containing the principal (user) and credentials (password or equivalent).
- Used by Spring Security to hold authentication details and roles for the user.
- Works in conjunction with `AuthenticationManager` to authenticate users.
- Once authenticated, token is stored in `SecurityContextHolder`.
- Used to grant access to protected resources based on roles and authorities.

### Methods

| Return Type | Method Name & Parameters                                           | Description                                                                 |
|-------------|--------------------------------------------------------------------|-----------------------------------------------------------------------------|
| Object      | `getPrincipal()`                                                   | Returns the principal (user) associated with the authentication.           |
| Object      | `getCredentials()`                                                 | Returns the credentials associated with the authentication.                 |
| Collection<? extends GrantedAuthority> | `getAuthorities()`                                       | Returns the authorities (roles) granted to the authenticated user.        |
| boolean     | `isAuthenticated()`                                                | Returns whether the authentication token is valid or not.                  |
| void        | `setDetails(Object details)`                                       | Sets additional details for the authentication token (e.g., session info). |

### Code Implementation

```java
package com.springjwt.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import com.springjwt.util.JWTUtil;
import com.springjwt.service.CustomUserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTUtil jwtUtil;

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }

        // create jwt token
        String jwt = jwtUtil.generateToken(authRequest.getUsername());

        return jwt;
    }
}
```