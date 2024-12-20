# Actuators
Spring Boot Actuators provide production-ready features to help monitor and manage applications. They include built-in endpoints for health checks, metrics, and other operational tools.

## Advantages
1. **Ease of Monitoring**: Provides comprehensive insights into application performance.
2. **Health Indicators**: Tracks the health of various application components.
3. **Customization**: Easily extendable to add custom endpoints.
4. **Integration**: Works seamlessly with monitoring tools like Prometheus and Grafana.
5. **Security**: Offers fine-grained control over endpoint access.

## Use Cases
1. Monitoring application health.
2. Tracking system metrics like memory usage and active threads.
3. Debugging production issues.
4. Ensuring service availability.
5. Automating system recovery based on health checks.

## Steps to Enable and Use Actuators

### 1. Add Dependency
Include the Spring Boot Actuator dependency in your `pom.xml`:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

### 2. Configure Actuator in `application.properties`
Define which endpoints to expose:
```properties
management.endpoints.web.exposure.include=*
```
This exposes all endpoints. You can also specify individual endpoints (e.g., `health`, `info`).

### 3. Securing Endpoints
Configure security for actuator endpoints. Example for basic authentication:
```properties
management.endpoints.web.exposure.include=health,info
management.endpoint.health.probes.enabled=true
management.endpoints.web.base-path=/actuator
spring.security.user.name=admin
spring.security.user.password=admin
```

### 4. Access Actuator Endpoints
Start the application and access endpoints like:
- Health: `http://localhost:8080/actuator/health`
- Metrics: `http://localhost:8080/actuator/metrics`

### 5. Custom Endpoints
Define custom endpoints if needed:
```java
package prasu.Config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Endpoint(id = "features")
public class FeatureEndPoint {

    private final Map<String, Feature> features = new ConcurrentHashMap<>();

    FeatureEndPoint() {
        features.put("Department", new Feature(true));
        features.put("User", new Feature(false));
        features.put("Authentication", new Feature(false));
    }

    @ReadOperation
    public Map<String, Feature> getFeatures() {
        return features;
    }

    @ReadOperation
    public Feature feature(@Selector String name) {
        return features.get(name);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Feature {
        private boolean isEnabled;
    }
}

```
Access it at `http://localhost:8080/actuator/custom`.

## Actuator Endpoints and Parameters

### 1. `health`
**Description**: Provides application health status.
**Parameters**:
- `show-details`: `always`, `when_authorized`, `never` (controls visibility of details).

### 2. `info`
**Description**: Displays application information.
**Parameters**: None by default. Use `application.properties` to customize.

### 3. `metrics`
**Description**: Exposes various metrics (e.g., memory, CPU, threads).
**Parameters**:
- `tags`: Filter metrics by tags.

### 4. `env`
**Description**: Displays environment properties.
**Parameters**:
- `pattern`: Filter environment keys.

### 5. `loggers`
**Description**: Manages application logging levels.
**Parameters**:
- `name`: Logger name to query or modify.
- `level`: Logging level to set.

### 6. `beans`
**Description**: Lists all Spring beans.
**Parameters**: None.

### 7. `mappings`
**Description**: Provides request mappings.
**Parameters**: None.

### 8. `threaddump`
**Description**: Provides thread dump of the application.
**Parameters**: None.

### 9. `auditevents`
**Description**: Displays audit events.
**Parameters**:
- `principal`: Filter by user.
- `type`: Filter by event type.

### 10. `shutdown`
**Description**: Shuts down the application.
**Parameters**: None (disabled by default for safety).

## Example Code

### Custom Health Indicator
```java
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        boolean error = checkCustomHealth(); // Your custom health check logic
        if (error) {
            return Health.down().withDetail("CustomError", "Service is down").build();
        }
        return Health.up().build();
    }

    private boolean checkCustomHealth() {
        // Custom logic to determine health
        return false;
    }
}
```

### Secured Actuator Configuration
```java
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/actuator/**").authenticated()
            .and()
            .httpBasic();
    }
}
```