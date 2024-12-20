# Lombok Annotations and Design Patterns

Lombok is a popular Java library that helps reduce boilerplate code by automatically generating methods like getters, setters, constructors, and more. It uses annotations to simplify repetitive tasks, making the code more readable and maintainable.

---

## Key Lombok Annotations

### 1. `@Getter`
- Automatically generates getter methods for all fields of a class.

Example:
```java
@Getter
public class User {
    private String name;
    private int age;
}
// Generates: getName() and getAge()
```

### 2. `@Setter`
- Automatically generates setter methods for all fields of a class.

Example:
```java
@Setter
public class User {
    private String name;
    private int age;
}
// Generates: setName(String name) and setAge(int age)
```

### 3. `@ToString`
- Generates a `toString()` method that includes all fields.
- **exclude**: Specify fields to exclude from the `toString()` method.

Example:
```java
@ToString
public class User {
    private String name;
    private int age;
}
// Generates: toString() -> "User(name=..., age=...)"
```

### 4. `@AllArgsConstructor`
- Generates a constructor with arguments for all fields in the class.

Example:
```java
@AllArgsConstructor
public class User {
    private String name;
    private int age;
}
// Generates: User(String name, int age)
```

### 5. `@NoArgsConstructor`
- Generates a no-argument constructor.
- Useful for frameworks like Hibernate that require a default constructor.

Example:
```java
@NoArgsConstructor
public class User {
    private String name;
    private int age;
}
// Generates: User()
```

### 6. `@Data`
- Combines `@Getter`, `@Setter`, `@ToString`, `@EqualsAndHashCode`, and `@RequiredArgsConstructor`.
- Ideal for DTOs or simple data-carrying classes.

Example:
```java
@Data
public class User {
    private String name;
    private int age;
}
// Generates: getters, setters, toString, hashCode, equals, and required args constructor.
```

### 7. `@Builder`
- Implements the Builder pattern, allowing step-by-step object construction.
- Can be combined with `@AllArgsConstructor` or `@NoArgsConstructor` for greater flexibility.

Example:
```java
@Builder
public class User {
    private String name;
    private int age;
}

// Usage:
User user = User.builder()
                .name("John")
                .age(30)
                .build();
```

### 8. `@EqualsAndHashCode`
- Generates `equals()` and `hashCode()` methods.
- **exclude**: Specify fields to exclude from these methods.
- **callSuper**: Include fields from the superclass.

Example:
```java
@EqualsAndHashCode
public class User {
    private String name;
    private int age;
}
// Generates: equals() and hashCode() methods based on `name` and `age`
```

---

## Design Patterns with Lombok

### 1. **Builder Pattern**
- The `@Builder` annotation simplifies the Builder pattern by providing a fluent API for object construction.

Example:
```java
@Builder
public class Order {
    private String product;
    private int quantity;
    private double price;
}

// Usage:
Order order = Order.builder()
                   .product("Laptop")
                   .quantity(2)
                   .price(1200.50)
                   .build();
```

### 2. **Singleton Pattern**
- Achieved using a private constructor and a static method for instance retrieval.

Example:
```java
@Getter
public class Singleton {
    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}
```

### 3. **Factory Pattern**
- Simplifies object creation with factory methods.

Example:
```java
public class UserFactory {
    public static User createUser(String name, int age) {
        return new User(name, age);
    }
}

@AllArgsConstructor
@Getter
public class User {
    private String name;
    private int age;
}

// Usage:
User user = UserFactory.createUser("Alice", 25);
```

### 4. **Prototype Pattern**
- Implements cloning for object reuse.

Example:
```java
@Data
public class Prototype implements Cloneable {
    private String data;

    @Override
    public Prototype clone() {
        try {
            return (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

// Usage:
Prototype original = new Prototype();
original.setData("Original Data");
Prototype copy = original.clone();
```

---

## Best Practices

1. **Minimize Boilerplate**: Use Lombok annotations to simplify repetitive code.
2. **Selective Usage**: Avoid overusing `@Data` in classes with complex business logic.
3. **Explicit Exclusions**: Use `exclude` parameters in annotations to prevent unnecessary fields in generated methods.
4. **Combine Annotations**: Combine annotations like `@Builder` with others (`@AllArgsConstructor`) for flexible patterns.
5. **Readability**: Use annotations thoughtfully to maintain code readability for other developers.

---

## Conclusion

Lombok annotations, combined with design patterns, streamline Java development by reducing boilerplate and promoting best practices. Proper usage enhances code clarity, maintainability, and scalability.
