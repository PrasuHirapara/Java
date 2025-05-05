## JwtAuthFilter

### Introduction

* Custom filter extending `OncePerRequestFilter`.
* Intercepts every incoming request.
* Extracts JWT token from the `Authorization` header.
* Validates token using `JWTUtil`.
* If valid, sets authentication in Spring Security's `SecurityContextHolder`.
* Allows the request to proceed if token is valid.

### Methods

| Return Type | Method Name & Parameters                                                                        | Description                                                               |
| ----------- | ----------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------- |
| void        | `doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)` | Extracts JWT, validates it, and sets the authentication context if valid. |

### Code Implementation

```java
@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    JWTUtil jwtUtil;

    @Autowired
    CustomUserService customUserService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String authToken = null;
        String username = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            authToken = authHeader.substring(7);
            username = jwtUtil.extractUsername(authToken);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = customUserService.loadUserByUsername(username);

            if (jwtUtil.validateToken(authToken, userDetails, username)) {
                UsernamePasswordAuthenticationToken authenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
```
