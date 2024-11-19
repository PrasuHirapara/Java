
# Exception Handling
**Exception Handling** is a mechanism to handle runtime errors, allowing the program to maintain its normal flow.

## Difference Between Exception and Error

| Exception       | Error           |
|-----------------|-----------------|
| Recoverable     | Irrecoverable   |
| Checked/Unchecked | Always unchecked |
| User-programming related | System related  |

## Adding Exception Signature to Method in Java

When a method can throw a checked exception, it must declare the exception using the `throws` keyword.
```java
public static void throwError() throws CustomException {
    throw new CustomException("Exception");
}
```

## Throwable Class

**Definition**: The `Throwable` class is the superclass of all errors and exceptions in Java. It works by representing any issue that can be thrown or caught.

### Properties of Throwable:
- **getMessage**: Describes the error.
- **getCause**: Represents the underlying cause of the throwable.
- **printStackTrace**: Provides the execution path leading to the error.
- **Suppressed Exceptions**: Represents exceptions that were suppressed.

### Example:
```java
public class ThrowableExample {
    public static void main(String[] args) {
        try {
            Exception mainException = new Exception("Custom Message", new Throwable("Cause of Exception"));
            Exception suppressedException = new Exception("Suppressed Exception");
            mainException.addSuppressed(suppressedException); // Add suppressed exception

            throw mainException;
        } catch (Exception e) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("Cause: " + e.getCause());
            e.printStackTrace();  // Stack trace

            // Retrieve and display suppressed exceptions
            for (Throwable t : e.getSuppressed()) {
                System.out.println("Suppressed: " + t);
            }
        }
    }
}

```

## Child Classes of Throwable

- **Exception**: Represents conditions that a program might want to catch.
    - Properties: Message, Cause, Stack Trace, Suppressed Exceptions
- **Error**: Represents serious issues that applications should not catch.
    - Properties: Same as Exception class

### Flowchart:
```
Object
  |
Throwable
  |
  +-- Exception
  |     |
  |     +-- Checked Exception
  |     +-- Unchecked Exception
  |
  +-- Error
```

## `try`, `catch`, and `finally` in Java

### `try` block:
Used to enclose code that might throw an exception.

### `catch` block:
Handles exceptions thrown by the `try` block.

### `finally` block:
Executes code regardless of whether an exception was thrown or handled.

### Example:
```java
public class TryCatchFinallyExample {
    public static void main(String[] args) {
        try {
            int data = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e);
        } finally {
            System.out.println("Finally block executed");
        }
    }
}
```

## Creating and Running a Custom Exception in Java

### Step 1: Define the Custom Exception Class
You need to create a class that extends `Exception` or `RuntimeException`.

```java
// Custom checked exception
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

// Custom unchecked exception
class CustomRuntimeException extends RuntimeException {
    public CustomRuntimeException(String message) {
        super(message);
    }
}
```

### Step 2: Throw the Custom Exception
Now, you can throw your custom exception in the code.

```java
public class CustomExceptionTest {
    public static void main(String[] args) {
        try {
            // Throwing a custom checked exception
            throw new CustomException("This is a custom checked exception");
        } catch (CustomException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // Throwing a custom unchecked exception
        throw new CustomRuntimeException("This is a custom unchecked exception");
    }
}
```

### Step 3: Compile and Run the Code
1. **Save the Java file** containing both the custom exception class and the test class.
2. **Compile the file** using `javac CustomExceptionTest.java`.
3. **Run the code** using `java CustomExceptionTest`.

```bash
javac CustomExceptionTest.java
java CustomExceptionTest
```

When the code is run, it will first catch the custom checked exception, then throw and terminate due to the unchecked exception.

---