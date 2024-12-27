# RegisteredClient in Spring Security

## Introduction
The `RegisteredClient` class in Spring Security represents a registered OAuth2 client. It encapsulates the client configuration, such as client ID, client secret, authorized grant types, and redirect URIs, which are critical for enabling secure communication between the authorization server and client applications.

---

## Key Features

1. **Client Identification**:
    - Unique `clientId` and optional `clientSecret` to identify and authenticate the client.

2. **Grant Types**:
    - Defines the OAuth2 grant types supported by the client (e.g., `authorization_code`, `client_credentials`).

3. **Redirect URIs**:
    - Specifies allowed redirect URIs for the authorization flow.

4. **Scopes**:
    - Defines the permissions or access levels requested by the client.

5. **Token Settings**:
    - Configurable token expiration and reuse policies.

6. **Client Authentication Methods**:
    - Supported methods for authenticating the client, such as `client_secret_basic` or `client_secret_post`.

---

## Key Methods in RegisteredClient

- **`String getId()`**: Returns the unique ID of the registered client.
- **`String getClientId()`**: Returns the client ID.
- **`String getClientSecret()`**: Returns the client secret.
- **`Set<AuthorizationGrantType> getAuthorizationGrantTypes()`**: Returns the set of authorized grant types for the client.
- **`Set<String> getRedirectUris()`**: Returns the set of redirect URIs allowed for the client.
- **`Set<String> getScopes()`**: Returns the set of scopes requested by the client.
- **`ClientAuthenticationMethod getClientAuthenticationMethods()`**: Returns the supported authentication methods for the client.
- **`TokenSettings getTokenSettings()`**: Returns the token settings for the client.
- **`ClientSettings getClientSettings()`**: Returns additional settings for the client, such as PKCE requirements.

---

## Example Usage

### Creating a RegisteredClient
```java
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

import java.time.Duration;

public class OAuth2ClientConfig {
    public RegisteredClient createRegisteredClient() {
        return RegisteredClient.withId("client-1")
            .clientId("my-client-id")
            .clientSecret("my-client-secret")
            .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
            .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
            .redirectUri("http://localhost:8080/callback")
            .scope("read")
            .scope("write")
            .tokenSettings(TokenSettings.builder()
                .accessTokenTimeToLive(Duration.ofHours(1))
                .refreshTokenTimeToLive(Duration.ofDays(30))
                .build())
            .clientSettings(ClientSettings.builder()
                .requireProofKey(true)
                .build())
            .build();
    }
}
```

---

## Use Cases

1. **Client Registration**:
    - Register clients with specific configurations for different applications or services.

2. **Secure Communication**:
    - Authenticate clients and authorize access to protected resources.

3. **Token Management**:
    - Configure token lifetimes and policies tailored to client needs.

---

## Benefits

1. **Customizable**: Flexible configuration for diverse client requirements.
2. **Secure**: Supports secure authentication and authorization practices.
3. **Interoperable**: Aligns with OAuth2 specifications for compatibility across systems.

---

## Conclusion
The `RegisteredClient` class is a core component in Spring Security's OAuth2 framework. It simplifies the management of OAuth2 clients and their configurations, providing a secure and flexible foundation for building authorization servers and enabling client interactions.

