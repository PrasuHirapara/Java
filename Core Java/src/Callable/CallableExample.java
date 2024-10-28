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
            System.out.println("Exception: " + e.toString());
        } finally {
            executor.shutdown();
        }

        System.out.println("Main method");
    }
}