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