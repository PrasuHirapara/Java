# Introduction to Spring Security

Spring Security is a powerful and highly customizable framework used to manage authentication (who you are) and authorization (what you can do) in Java-based applications. It is the industry-standard solution for securing applications built with the Spring Framework. Spring Security helps protect your application from common security threats and integrates smoothly with the entire Spring ecosystem.

---

## Why Use Spring Security?

* Complete Authentication and Authorization Support
  Easily manage login systems and control access to different parts of your application.

* Protection Against Common Security Threats
  Includes built-in protection against:

  * CSRF (Cross-Site Request Forgery)
  * Session Fixation Attacks
  * Clickjacking
  * XSS (Cross-Site Scripting) and more

* Role-Based and Fine-Grained Access Control
  Allows setting permissions based on roles or even user-specific rules.

* Highly Extensible and Flexible
  Supports multiple authentication types like form login, OAuth2, LDAP, SAML, etc., and can be easily customized to fit your needs.

* Seamless Integration with Spring Framework
  Works out of the box with Spring Boot, Spring MVC, and other Spring modules.


---

## Required Dependencies (pom.xml)

Add the following dependencies in your `pom.xml` file to use Spring Security in a Spring Boot project:

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

    <!-- OAuth2 Client (Optional, if using OAuth2 login) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-oauth2-client</artifactId>
    </dependency>

    <!-- Spring Boot DevTools (Optional, for development) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
    </dependency>
</dependencies>
```
---

## Authentication vs Authorization

| Aspect  | Authentication                        | Authorization                          |
| ------- | ------------------------------------- | -------------------------------------- |
| Purpose | Verifies who the user is              | Decides what the user is allowed to do |
| Example | Logging in with username and password | Accessing the admin dashboard or API   |
| Time    | Happens before authorization          | Happens after authentication           |
| Focus   | Identity verification                 | Access control to resources            |
| Result  | User is identified                    | Permissions are granted or denied      |

---

## Spring Security Authentication Flow

![Spring Security Flowchart](https://github.com/PrasuHirapara/Java/blob/main/Spring/Spring%20Security/Documentation/flowchart.png?raw=true)

This flow shows how requests are processed through a chain of filters and components to authenticate and authorize users.

---

## Core Components in the Flow

### Filters

* **SecurityContextHolderFilter**
  Initializes and manages the security context for each request. It holds authentication details for the current thread and makes them available throughout the request lifecycle.

* **UsernameAndPasswordAuthenticationFilter**
  Intercepts login requests, extracts credentials (username and password), creates an authentication token, and delegates authentication to the AuthenticationManager.

* **ExceptionTranslationFilter**
  Handles security-related exceptions. It sends an error response or redirects to a login page if authentication or authorization fails.

### SecurityContextHolder

Stores the `SecurityContext`, which contains the principal (authenticated user details) for the current request. This context is available across different parts of the application and helps in applying user-specific logic.

### AuthenticationManager (ProviderManager)

Coordinates the authentication process by delegating to one or more AuthenticationProvider implementations. It tries each provider in order until authentication succeeds or all fail.

### Authentication Providers

* **DAOAuthenticationProvider**
  Authenticates users using a database. It relies on `UserDetailsService` and a password encoder.

* **OAuth2LoginAuthenticationProvider**
  Handles OAuth2-based logins. It validates the access token and retrieves user information from the OAuth2 provider.

* **LDAPAuthenticationProvider**
  Authenticates users using an LDAP server by validating user credentials against the directory.

### PasswordEncoder

Encodes and verifies passwords to ensure secure storage and comparison. Common implementations include BCryptPasswordEncoder and SCryptPasswordEncoder.

### UserDetailsService

Provides user information to authentication providers.

* **InMemoryUserDetailsManager**
  Stores user details in memory. Useful for development or testing purposes.

* **JDBCUserDetailsManager**
  Loads user details from a relational database using JDBC.
* 
---

## HTTP Request-to-Response Flow in Spring Security

Below are the simple and clear steps of how a client HTTP request is handled by Spring Security. Each step explains what it does, how it works, which class or filter is involved, and what happens next.

1. **Client Sends Request**

  * **What**: The browser or app sends an HTTP request to your web application.
  * **How**: The servlet container (like Tomcat) receives the request.
  * **Class/Filter**: No specific class yet; this is handled by the servlet container.
  * **Next**: The container forwards the request to `DelegatingFilterProxy`.

2. **DelegatingFilterProxy Delegation**

  * **What**: Connects servlet filters with Spring-managed security beans.
  * **How**: Delegates the request to the Spring bean `springSecurityFilterChain`.
  * **Class/Interface**: `DelegatingFilterProxy` (implements `javax.servlet.Filter`).
  * **Next**: Calls `FilterChainProxy.doFilter()`.

3. **FilterChainProxy Selection**

  * **What**: Chooses the right set of security filters for the request.
  * **How**: Matches the request to one of the configured `SecurityFilterChain`s.
  * **Class**: `FilterChainProxy`.
  * **Next**: Passes the request through the matched filter chain.

4. **SecurityContextPersistenceFilter**

  * **What**: Manages the user’s security context.
  * **How**: Loads the context from the session or creates a new one.
  * **Class**: `SecurityContextPersistenceFilter`.
  * **Next**: Stores the context in `SecurityContextHolder`.

5. **CsrfFilter**

  * **What**: Checks for CSRF protection.
  * **How**: Validates the CSRF token in the request against the token in the session.
  * **Class**: `CsrfFilter`.
  * **Next**: If valid, continues; else throws `InvalidCsrfTokenException`.

6. **UsernamePasswordAuthenticationFilter**

  * **What**: Handles login forms.
  * **How**: Extracts username/password, creates an authentication token, and calls `AuthenticationManager`.
  * **Class**: `UsernamePasswordAuthenticationFilter`.
  * **Next**: Sends the token to `ProviderManager` for authentication.

7. **AuthenticationManager / ProviderManager**

  * **What**: Coordinates authentication using various providers.
  * **How**: Tries each `AuthenticationProvider` until one works.
  * **Class/Interface**: `AuthenticationManager` is the interface; `ProviderManager` is the main implementation.
  * **Next**: Returns an authenticated token or throws an exception.

8. **UserDetailsService (or other Provider)**

  * **What**: Validates login details.
  * **How**: Uses `UserDetailsService` to find the user and `PasswordEncoder` to check the password.
  * **Class**: `UserDetailsService`.
  * **Next**: If successful, sets the authenticated token in `SecurityContextHolder`.

9. **SecurityContextHolder Update**

  * **What**: Saves the authenticated user details.
  * **How**: Sets the authentication in `SecurityContextHolder.getContext()`.
  * **Class**: `SecurityContextHolder`.
  * **Next**: Other filters use this info for authorization checks.

10. **FilterSecurityInterceptor**

  * **What**: Checks if the user has access to the requested URL.
  * **How**: Compares the URL with security settings and consults `AccessDecisionManager`.
  * **Class**: `FilterSecurityInterceptor`.
  * **Next**: Grants or denies access; if denied, throws `AccessDeniedException`.

11. **ExceptionTranslationFilter**

  * **What**: Handles security errors.
  * **How**: Catches `AuthenticationException` or `AccessDeniedException` and responds properly.
  * **Class**: `ExceptionTranslationFilter`.
  * **Next**: Sends error response or redirects to login.

12. **Controller / Resource Execution**

  * **What**: Processes the actual request logic.
  * **How**: Spring MVC routes the request to the right controller.
  * **Class**: `DispatcherServlet`.
  * **Next**: Runs your app’s logic and prepares the response.

13. **SecurityContextPersistenceFilter (Post-Processing)**

  * **What**: Final step to clean up the security context.
  * **How**: Saves the context back to the session and clears the thread.
  * **Class**: `SecurityContextPersistenceFilter`.
  * **Next**: The response is sent back to the client.

## Summary

Spring Security secures Java applications by managing authentication and authorization through a well-structured chain of filters, context holders, managers, and providers. Its modular architecture supports extensibility and integration with various login methods. This makes it a reliable choice for protecting Spring-based applications against modern security threats and managing fine-grained access control.
