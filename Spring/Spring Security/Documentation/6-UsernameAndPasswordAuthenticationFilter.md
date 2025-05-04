# UsernameAndPasswordAuthenticationFilter

## Introduction

* This filter is part of the Spring Security filter chain.
* It processes authentication requests using a username and password.
* Intercepts HTTP POST requests (usually to `/login`).
* It extracts credentials, creates an `Authentication` token, and delegates authentication to `AuthenticationManager`.

---

## Method Summary

| Return Type      | Method Signature                                                                                                                   | Description                                                                               |
| ---------------- | ---------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------- |
| `Authentication` | `attemptAuthentication(HttpServletRequest request, HttpServletResponse response)`                                                  | Attempts to authenticate the user based on the username and password sent in the request. |
| `void`           | `setAuthenticationManager(AuthenticationManager authenticationManager)`                                                            | Sets the `AuthenticationManager` used for authentication.                                 |
| `void`           | `setFilterProcessesUrl(String filterProcessesUrl)`                                                                                 | Sets the URL that this filter processes authentication requests from.                     |
| `String`         | `getFilterProcessesUrl()`                                                                                                          | Returns the URL this filter processes authentication requests from.                       |
| `void`           | `successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)` | Called when authentication is successful.                                                 |
| `void`           | `unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed)`             | Called when authentication fails.                                                         |

---

## Implementation

```java
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public CustomUsernamePasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl("/login"); // Custom login endpoint
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        return authenticationManager.authenticate(token);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write("ResponseType: FOUND\nAuthentication successful");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("ResponseType: NOT_FOUND\nAuthentication failed: " + failed.getMessage());
    }
}
```

This class can be registered as a bean or added to the security filter chain configuration as required.
