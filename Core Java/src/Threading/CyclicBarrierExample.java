package Threading;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("All parties have arrived at the barrier, let's proceed");
        });

        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is waiting at the barrier");
                barrier.await();
                System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        new Thread(task, "Thread 1").start();
        new Thread(task, "Thread 2").start();
        new Thread(task, "Thread 3").start();
    }
}