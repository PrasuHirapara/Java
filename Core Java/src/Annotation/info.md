# Annotations
Annotations provide metadata about the code and are used to give additional information to the compiler, tools, or libraries during runtime or compile-time. They don't affect the actual execution of the program.

## Using Annotations with Interfaces
Annotations can be used with interfaces to convey special meaning. For example, the `@FunctionalInterface` annotation ensures that an interface has exactly one abstract method.

### Example of Annotation Usage
```java
@FunctionalInterface
interface MyFunctionalInterface {
    void performTask(); // Single abstract method
}
```

### Common Annotations in Interfaces

- **@FunctionalInterface**: Ensures the interface has only one abstract method.
- **@Override**: Used when implementing or overriding methods from an interface.
- **@Deprecated**: Marks an interface or method as deprecated, indicating it should not be used.
- **@SuppressWarnings**: Suppresses specific warnings that the compiler might give.
- **@Retention**: Specifies how long the annotation should be retained (source, class, or runtime).

## Creating Your Own Annotations
To create your own annotation in Java, use the `@interface` keyword. You can specify default values for annotation members and use it as metadata.

## Steps:
1. Create the custom annotation using `@interface`.
2. Define the retention policy and target using `@Retention` and `@Target`.
3. Apply the annotation to the desired elements.
4. Use reflection to access the annotation at runtime.

### Example of Custom Annotation
```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Custom annotation definition
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyCustomAnnotation {
    String value() default "Default message";
}

// Using custom annotation
class TestAnnotation {
    @MyCustomAnnotation(value = "This is a custom annotation.")
    public void display() {
        System.out.println("Custom Annotation Example.");
    }
}
```
### Example Usage of Custom Annotation
```java
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        TestAnnotation obj = new TestAnnotation();
        Method method = obj.getClass().getMethod("display");

        // Check if the method has MyCustomAnnotation
        if (method.isAnnotationPresent(MyCustomAnnotation.class)) {
            MyCustomAnnotation annotation = method.getAnnotation(MyCustomAnnotation.class);
            System.out.println("Annotation Value: " + annotation.value());
        }

        // Calling the method
        obj.display(); // Output: Custom Annotation Example.
    }
}
```
### Explanation:
- **@Retention(RetentionPolicy.RUNTIME)**: The annotation is retained at runtime, so it can be accessed via reflection.
- **@Target(ElementType.METHOD)**: Specifies that the annotation can only be applied to methods.
