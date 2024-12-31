
# Lambda Function
A lambda expression is a concise representation of an anonymous function that can be used to implement a method defined by a functional interface. It allows you to create instances of interfaces with a single abstract method (SAM) more succinctly.

## Syntax
The basic syntax of a lambda expression:
```java
(parameters) -> { body }
```

### Example:
```java
// Lambda expression for a Runnable interface
Runnable r = () -> { System.out.println("Lambda expression"); };
```

### Rules:
- A lambda expression can have zero or more parameters.
- Variable used in lambda expression should be final or effectively final
- The data type of parameters can be omitted as it is inferred from the context.
- If there's a single parameter, you can omit the parentheses.
- If the body contains a single statement, the curly braces and return keyword can be omitted.

## Examples

### No Parameters:
```java
// Lambda expression with no parameters
() -> System.out.println("No parameters");
```

### Single Parameter:
```java
// Lambda expression with one parameter
(name) -> System.out.println("Hello, " + name);
```

### Multiple Parameters:
```java
// Lambda expression with multiple parameters
(int a, int b) -> { return a + b; };
```

## Functional Interface
A functional interface is an interface that contains only one abstract method. It can have multiple default or static methods but must have exactly one abstract method, which is the target for lambda expressions.

### Example:
```java
@FunctionalInterface
interface Drawable {
    void draw();
}
```

## Relationship with Lambda Functions
Lambda expressions are primarily used with functional interfaces. When you use a lambda expression, the compiler translates it into an instance of the functional interface, making it easier to write code that is both compact and expressive.

## Usage
Lambda expressions are commonly used in functional programming, especially in:
- Streams
- Collection
- Multi-threading environments

---

```java
public class Main {

    public static void main(String[] args) {
        // Example 1: Lambda expression with no parameters
        Runnable noParam = () -> System.out.println("Result: No parameters");
        noParam.run(); // Output: No parameters
        
        // Example 2: Lambda expression with one parameter
        Greeting greetWithName = (name) -> System.out.println("Result: Hello, " + name);
        greetWithName.sayHello("John"); // Output: Hello, John
        
        // Example 3: Lambda expression with multiple parameters
        MathOperation add = (a, b) -> a + b;
        int result = add.operate(10, 20);
        System.out.println("Result: Sum is " + result); // Output: Sum is 30
    }

    // Functional interface for greeting
    @FunctionalInterface
    interface Greeting {
        void sayHello(String name);
    }

    // Functional interface for math operation
    @FunctionalInterface
    interface MathOperation {
        int operate(int a, int b);
    }
}
```
