# Spring EventListener

Spring's `@EventListener` annotation is used to handle application events in a more declarative and convenient manner. This mechanism allows you to respond to various application events, whether standard or custom, asynchronously or synchronously.

---

## Key Concepts

### 1. **What is `@EventListener`?**
The `@EventListener` annotation marks a method as a listener for application events. These events can be published using `ApplicationEventPublisher` or any other Spring mechanism for event handling.

### 2. **Automatic Detection**
Methods annotated with `@EventListener` are automatically detected by the Spring framework if their enclosing class is a Spring-managed bean.

---

## Basic Usage

### Example 1: Listening to a Standard Event

```java
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class StartupEventListener {

    @EventListener
    public void handleContextRefresh(ContextRefreshedEvent event) {
        System.out.println("Context refreshed: " + event.getTimestamp());
    }
}
```

- **Explanation**:
    - This example listens to the `ContextRefreshedEvent` and performs an action when the application context is refreshed.

---

### Example 2: Listening to a Custom Event

#### Define the Event
```java
public class CustomEvent {
    private final String message;

    public CustomEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
```

#### Publish the Event
```java
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class CustomEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    public CustomEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publishEvent(String message) {
        CustomEvent event = new CustomEvent(message);
        eventPublisher.publishEvent(event);
    }
}
```

#### Listen to the Event
```java
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CustomEventListener {

    @EventListener
    public void handleCustomEvent(CustomEvent event) {
        System.out.println("Received custom event - Message: " + event.getMessage());
    }
}
```

---

## Advanced Usage

### 1. **Conditional Listening**
Use the `condition` attribute to specify conditions under which the listener should execute.

#### Example:
```java
@EventListener(condition = "#event.message.startsWith('Important')")
public void handleImportantEvents(CustomEvent event) {
    System.out.println("Important Event: " + event.getMessage());
}
```

- **Explanation**: The listener will only handle events where the message starts with `Important`.

---

### 2. **Asynchronous Event Handling**
To handle events asynchronously, annotate the class or method with `@Async`.

#### Example:
```java
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncEventListener {

    @Async
    @EventListener
    public void handleAsyncEvent(CustomEvent event) {
        System.out.println("Handling event asynchronously: " + event.getMessage());
    }
}
```

- **Requirements**:
    - Enable asynchronous processing using `@EnableAsync` in a configuration class.
    - Ensure a task executor is configured.

---

## Error Handling
Spring allows you to handle exceptions thrown by event listeners through custom error handling mechanisms.

### Example:
```java
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListenerErrorHandler;

@Component
public class EventErrorHandler implements EventListenerErrorHandler {

    @Override
    public void handleError(Throwable t) {
        System.err.println("Error occurred in event listener: " + t.getMessage());
    }
}
```

Configure it via the `@EventListener` annotation:
```java
@EventListener(errorHandler = "eventErrorHandler")
public void handleFaultyEvent(CustomEvent event) {
    throw new RuntimeException("Simulated Exception");
}
```

---

## Real-World Applications
1. **Audit Logging**: Listen to application-specific events for tracking user actions.
2. **Email Notifications**: Trigger email alerts when specific events occur.
3. **Cache Updates**: Refresh or invalidate cache based on business events.

---

## Key Points to Remember
1. `@EventListener` works seamlessly with custom and standard Spring events.
2. Asynchronous event handling improves performance but requires proper configuration.
3. Conditions and error handling provide finer control over event listener behavior.
4. Ensure that the listener classes are registered as Spring beans for proper detection.

---
