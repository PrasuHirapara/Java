## JWTUtil

### Introduction

* A utility component for creating and validating JWT tokens.
* Encapsulates JWT logic such as token generation, parsing, and validation.
* Ensures secure communication by embedding claims and signing tokens with a secret key.

### Methods

| Return Type | Method Name & Parameters                           | Description                                                          |
| ----------- | -------------------------------------------------- | -------------------------------------------------------------------- |
| String      | `generateToken(String username)`                   | Generates a JWT with subject, issue date, expiration, and signature. |
| String      | `extractUsername(String token)`                    | Extracts the username (subject) from the JWT.                        |
| boolean     | `validateToken(String token, UserDetails, String)` | Validates token signature, expiration, and username consistency.     |
| boolean     | `isTokenExpired(String token)`                     | Checks whether the token's expiration date has passed.               |

### Code Implementation

```java
@Component
public class JWTUtil {

    private final String SECRET = "secret-key-is-nedded-to-be-too-much-longer-@423434252345325";
    private final long EXPIRATION_TIME = 1000 * 60 * 60;
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateToken(String username) {
        return Jwts.builder()
            .subject(username)
            .issuedAt(new Date())
            .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
            .signWith(key, SignatureAlgorithm.HS256)
            .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails, String username) {
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return Jwts.parser()
            .setSigningKey(key)
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getExpiration()
            .before(new Date());
    }
}
```

* The `JWTUtil` class ensures the secure creation and validation of tokens.
* Uses HMAC SHA256 for signing with a long secret key.
* Injected into controllers and filters to manage JWT lifecycle in request handling.
