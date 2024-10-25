package Threading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locking {

    static class BankAccount {
        protected final Lock lock = new ReentrantLock();
        private int balance = 100;

        public void withdraw(int amount) throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + " attempting to withdraw " + amount);

            if (lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    // Check balance after acquiring lock
                    if (amount <= balance) {
                        // Simulating a delay in withdrawal processing
                        Thread.sleep(3000);
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " successfully withdrawn. Balance " + balance);
                    } else {
                        System.out.println(Thread.currentThread().getName() + " unsuccessful - insufficient balance. Balance = " + balance);
                    }
                }catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // setting that this thread has been interrupted.
                }
                finally {
                    lock.unlock(); // Ensure the lock is released
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire lock and withdraw. Balance = " + balance);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        Runnable task = () -> {
            try {
                account.withdraw(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread t1 = new Thread(task, "Thread1");
        Thread t2 = new Thread(task, "Thread2");

        t1.start();
        t2.start();
    }
}
