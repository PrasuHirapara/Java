## AuthController

### Introduction

* Acts as the REST controller responsible for authenticating users.
* Provides the `/authenticate` endpoint that accepts login credentials.
* Relies on `AuthenticationManager` to validate user credentials.
* Generates and returns a JWT token upon successful authentication.
* Core to the login process in JWT-based Spring Security setups.

### Methods

| Return Type | Method Name & Parameters                          | Description                                                          |
| ----------- | ------------------------------------------------- | -------------------------------------------------------------------- |
| String      | `generateToken(@RequestBody AuthRequest request)` | Authenticates the user and returns a JWT if valid credentials given. |

### Code Implementation

```java
@RestController
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

        // Create JWT token
        String jwt = jwtUtil.generateToken(authRequest.getUsername());
        return jwt;
    }
}
```
