# Principal Interface in Java

## Introduction
The `Principal` interface is part of the `java.security` package. It represents an entity, such as an individual or a corporation, which can be authenticated and identified. The `Principal` interface is widely used in security-related contexts to encapsulate the identity of the authenticated entity.

---

## Methods in Principal Interface

- `String getName()` - Returns the name of the principal.
- `boolean equals(Object another)` - Compares this principal to the specified object for equality.
- `int hashCode()` - Returns a hash code for this principal.
- `String toString()` - Returns a string representation of the principal.

---

## Example Implementation
```java
import java.security.Principal;

public class CustomPrincipal implements Principal {
    private final String name;

    public CustomPrincipal(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        if (another == null || getClass() != another.getClass()) return false;
        CustomPrincipal that = (CustomPrincipal) another;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "CustomPrincipal{name='" + name + "'}";
    }

    public static void main(String[] args) {
        Principal principal = new CustomPrincipal("user1");
        System.out.println("Principal Name: " + principal.getName());
        System.out.println("Principal Details: " + principal.toString());
    }
}
```

---

## Use Cases

1. **Authentication Frameworks**: Represents authenticated user information in frameworks like Spring Security.
2. **Access Control**: Utilized in conjunction with `AccessControlContext` to check permissions.
3. **Custom Security Implementations**: Encapsulates identity information for custom security mechanisms.
4. **Logging and Auditing**: Stores and displays identity details for logging and auditing purposes.

---

## Conclusion
The `Principal` interface serves as a foundation for representing authenticated entities in Java. Its simple yet effective design ensures compatibility with various security frameworks and custom implementations, making it a key component in identity and access management.
