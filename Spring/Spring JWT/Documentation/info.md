# Introduction to Spring Security with JWT

Spring Security is a powerful and highly customizable framework used to manage authentication and authorization in Java applications. JSON Web Token (JWT) adds stateless and compact user session management to Spring applications, allowing tokens to be exchanged securely between client and server.

---

## Why Use JWT?

* Stateless — no server-side session storage required.
* Scalable across distributed systems and microservices.
* Secure data transmission via signed tokens.
* Easy to implement role-based access control.
* Simplified client-side storage and reuse of tokens.
* Enables Single Sign-On (SSO) patterns.
* Better suited for RESTful APIs than traditional sessions.

---

## Required Dependencies (pom.xml)

```xml
<dependencies>
    <!-- Spring Boot Starter Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Boot Starter Security -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>

    <!-- JJWT (Java JWT: API, Impl, Jackson) -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-api</artifactId>
        <version>0.11.2</version>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-impl</artifactId>
        <version>0.11.2</version>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-jackson</artifactId>
        <version>0.11.2</version>
        <scope>runtime</scope>
    </dependency>
</dependencies>
```

---

## Components in JWT

### 1. Header

* Specifies the algorithm used (e.g., HS256) and token type (JWT).

```json
{
  "alg": "HS256",
  "typ": "JWT"
}
```

### 2. Payload

* Contains claims like issuer, subject, roles, expiration.

```json
{
  "sub": "user@example.com",
  "role": "ADMIN",
  "iat": 1714859020,
  "exp": 1714862620
}
```

### 3. Signature

* Created using the encoded header, payload, and secret key.

```text
HMACSHA256(
  base64UrlEncode(header) + "." + base64UrlEncode(payload), secret
)
```

---

![Spring Security JWT Flow](https://github.com/PrasuHirapara/Java/blob/main/Spring/Spring%20JWT/Documentation/flowchart.png?raw=true)

---

## JWT Authentication Flow in Spring Security

1. **Client Sends Request**

    * Sends login credentials to `/authenticate` endpoint.
    * `AuthenticationController` receives the request.
    * Binds to `AuthenticationRequest` DTO.
    * Delegates to `AuthenticationManager` for validation.

2. **AuthenticationManager Delegates**

    * Internally uses `ProviderManager`.
    * Delegates to configured `AuthenticationProvider`.
    * Uses `UserDetailsService` to fetch user details.
    * Applies `PasswordEncoder` to verify hashed password.

3. **UserDetailsService Loads User**

    * Custom `UserDetailsService` implementation loads user by username.
    * Returns a `UserDetails` object with authorities and credentials.

4. **JWT Is Generated**

    * JWT created using `Jwts.builder()`.
    * Adds subject, roles, issue date, and expiry.
    * Signs with secret key and algorithm (e.g., HS256).
    * Logic typically inside `JwtService` or equivalent.

5. **Token Returned to Client**

    * JWT token returned in HTTP response body.
    * Frontend stores it in localStorage/session/cookie.

6. **Subsequent Request With Token**

    * Client includes JWT in `Authorization` header with format `Bearer <token>`.
    * All secure endpoints require this header.

7. **JwtAuthenticationFilter Intercepts**

    * Custom filter extends `OncePerRequestFilter`.
    * Intercepts incoming requests.
    * Extracts and parses JWT from Authorization header.

8. **Token Is Validated**

    * `JwtService` validates signature, expiration, and claims.
    * Returns username if valid, or throws exception if invalid/expired.

9. **Set Authentication in Context**

    * Uses `UsernamePasswordAuthenticationToken` to represent the user.
    * Sets authentication in `SecurityContextHolder`.
    * Makes user available to Spring Security context.

10. **Access Granted to Controller**

    * Filter chain continues to controller.
    * Annotations like `@PreAuthorize` or `@Secured` check roles/permissions.
    * Access is granted based on token claims.

11. **Response Returned**

    * Controller executes logic and returns data.
    * Response passes back through filters to client.

---

## Summary

JWT-based authentication in Spring Security combines stateless session handling with powerful request filtering. With components like `AuthenticationManager`, custom filters, `UserDetailsService`, and `JwtService`, it supports secure login and request validation using signed tokens.
