# Future Class in Java

The `Future` interface represents the result of an asynchronous computation. It allows us to check if the computation is complete, wait for its completion, and retrieve the result. The result can only be retrieved when the computation has finished; otherwise, the `get` method will block.

## Key Methods in the Future Interface

1. **`get()`** - Retrieves the result of the computation, blocking if necessary until it is available.
2. **`get(long timeout, TimeUnit unit)`** - Retrieves the result of the computation, waiting up to the specified timeout.
3. **`isDone()`** - Returns `true` if the computation is complete.
4. **`isCancelled()`** - Returns `true` if the task was cancelled before it completed.
5. **`cancel(boolean mayInterruptIfRunning)`** - Attempts to cancel the execution of the task.

## Understanding `Future<?>`

The `Future<?>` type signifies a `Future` that may return any type of result or no result at all. It is commonly used when the type of the result is not known beforehand or when the result is not relevant.

### Example of `Future<?>`

Here’s an extension of our previous example with a different `Callable` returning `void` (represented by `null`) to show the use of `Future<?>`.

```java
package Future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Callable returning an Integer result
        Callable<Integer> integerTask = () -> {
            Thread.sleep(1000);
            return 123;
        };

        // Callable with a Future<?> result (no actual return value)
        Callable<Void> voidTask = () -> {
            System.out.println("Executing a task with no return value.");
            Thread.sleep(500);
            return null;
        };

        Future<Integer> integerFuture = executor.submit(integerTask);
        Future<?> voidFuture = executor.submit(voidTask);

        try {
            System.out.println("Integer Future result: " + integerFuture.get());
            voidFuture.get(); // This will complete but has no return value
            System.out.println("Void Future result: " + voidFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
}
```
## Advantages of Future

- Allows asynchronous task handling with blocking and non-blocking options.
- Provides control over task execution, including canceling tasks.

## Disadvantages of Future

- Lacks flexibility in handling multiple tasks (resolved by CompletableFuture in Java 8).
- Blocking methods like `get` can lead to performance bottlenecks.

## Use Cases in Threading

- **Asynchronous task execution**: Suitable for tasks where waiting for a result is required but not immediately.
- **Task cancellation**: Effective for scenarios where tasks may need to be terminated under certain conditions.
- **Background computations**: Useful in GUIs where tasks need to run in the background, returning results upon completion.
