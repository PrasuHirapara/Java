package Threading;

import java.util.concurrent.*;

public class ThreadPooling {

    public static void main(String[] args) throws InterruptedException {

//        long startTime = System.currentTimeMillis();
////        Created 10 different thread to do one task
////        starting and joining is also done by us.
////        Thread head overload is too much for init and starting and destroying
//        for (int i = 0; i < 10; i++) {
//            int finalI = i; // variable inside lambda can not change
//            Thread thread = new Thread(() -> {
//                long result = factorial(finalI);
//                System.out.println(result);
//            });
//            thread.start();
//            thread.join();
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("Time taken: " + (endTime - startTime) + "\n");

//        instead use Thread pooling
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Future<?> future = service.submit(() -> {
                System.out.println(factorial(finalI));
            });
            System.out.println(future.state());
        }
        service.shutdown(); // does not wait for services to finish and continue main thread.
        service.awaitTermination(1000, TimeUnit.MILLISECONDS); // to stop main thread to run
        System.out.println("Main method");
    }

    private static long factorial(long n) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return n <= 0 ? 0 : result;
    }
}
