# AuthenticationManager (ProviderManager)

## Introduction
- `AuthenticationManager` is an interface used by Spring Security to handle the authentication process.
- `ProviderManager` is the default implementation of the `AuthenticationManager` that delegates authentication requests to one or more `AuthenticationProvider`s.
- It iterates over a list of providers, attempting to authenticate the user until one succeeds or all fail.
- Typically used in conjunction with `UsernamePasswordAuthenticationFilter` or custom authentication filters.

---

## Method Summary

| Return Type | Method Signature                                                        | Description |
|-------------|--------------------------------------------------------------------------|-------------|
| `Authentication` | `authenticate(Authentication authentication)`                           | Attempts to authenticate the provided `Authentication` object using registered `AuthenticationProvider`s. |
| `void`        | `setAuthenticationProviders(List<AuthenticationProvider> providers)`   | Sets a list of `AuthenticationProvider`s for authentication. |
| `List<AuthenticationProvider>` | `getAuthenticationProviders()`                              | Retrieves the list of configured `AuthenticationProvider`s. |
| `void`        | `afterPropertiesSet()`                                                   | Initializes the `AuthenticationManager` after the properties are set. |

---

## Implementation

```java
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationManagerResolver;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomAuthenticationManager implements AuthenticationManager {

    private List<AuthenticationProvider> authenticationProviders;

    public CustomAuthenticationManager(List<AuthenticationProvider> authenticationProviders) {
        this.authenticationProviders = authenticationProviders;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        for (AuthenticationProvider provider : authenticationProviders) {
            if (provider.supports(authentication.getClass())) {
                return provider.authenticate(authentication);
            }
        }
        throw new AuthenticationException("Authentication failed") {};
    }

    public void setAuthenticationProviders(List<AuthenticationProvider> providers) {
        this.authenticationProviders = providers;
    }

    public List<AuthenticationProvider> getAuthenticationProviders() {
        return authenticationProviders;
    }

    public void afterPropertiesSet() {
        // Initialize if necessary
    }
}
```