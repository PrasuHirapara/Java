
# Java Callable Interface

The `Callable` interface, part of `java.util.concurrent`, is used to define tasks that return results and may throw exceptions. It provides a more flexible alternative to `Runnable` for tasks that need to compute values.

- **Returns**: A result, or throws a checked exception.
- **Purpose**: Supports concurrent processing where the result of a task is needed.

## Callable Interface Overview

The `Callable` interface enables parallel tasks to compute results that can be retrieved once the task completes. Unlike `Runnable`, `Callable` can return a result and throw a checked exception.

### Method:
- **call()**: The single abstract method that computes and returns a result or throws an exception.

    - **Signature**: `V call() throws Exception`
    - **Type Parameters**: `<V>` the result type of the call method
    - **Example**: Computes a value and returns it.


## Using Callable with ExecutorService

To execute `Callable` tasks, submit them to an `ExecutorService`, such as a `ThreadPoolExecutor`. The `submit` method of `ExecutorService` returns a `Future` object, which can be used to retrieve the result.

### Steps to Use:
1. Define a class that implements `Callable` and override the `call()` method.
2. Submit the `Callable` task to an `ExecutorService`.
3. Retrieve the result from the `Future` object.

### Example:
```java
package Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExample {
  public static void main(String[] args) throws Exception {
    Callable<Integer> fact = new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        return 0;
      }
    };
    System.out.println(fact.call());

    ExecutorService executor = Executors.newFixedThreadPool(1);

    // Callable instance
    Callable<String> task = () -> {
      Thread.sleep(1000); // simulating a delay
      return "Task Result";
    };

    try {
      Future<String> future = executor.submit(task);
      System.out.println("Task submitted.");
      // Retrieve the result
      String result = future.get();  // blocking until result is available
      System.out.println("Result: " + result);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      executor.shutdown();
    }
  }
}
```

---

## Handling Exceptions with Callable

Since `Callable` can throw exceptions, it is useful for error-prone tasks. If an exception is thrown during `call()`, it is wrapped in an `ExecutionException` and rethrown by `Future.get()`.

### Example:
```java
package Concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableWithExceptionExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        // Callable instance with potential exception
        Callable<Integer> task = () -> {
            int result = 1 / 0; // will cause ArithmeticException
            return result;
        };

        try {
            Future<Integer> future = executor.submit(task);
            Integer result = future.get();  // throws ExecutionException
        } catch (Exception e) {
            System.err.println("Exception occurred: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
}
```

## Comparison with Runnable

While both `Callable` and `Runnable` represent tasks intended for concurrent execution, they have key differences:

| Feature            | Callable<V>        | Runnable            |
|--------------------|--------------------|---------------------|
| **Returns**        | V (result)         | void                |
| **Exception Handling** | Can throw checked exceptions | Only throws unchecked exceptions |
| **Method**         | `call()`           | `run()`             |
