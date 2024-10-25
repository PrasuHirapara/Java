
# Java Threading

Java supports multithreading, which allows concurrent execution of two or more parts of a program. Each part is called a thread. Multithreading helps make Java applications more efficient by utilizing the CPU more effectively.

---

## Ways to Create Threads in Java

### 1. Extending the `Thread` Class

The `Thread` class provides constructors and methods for creating and performing operations on a thread.

#### Methods in the `Thread` class:
- **`start()`**: Starts the execution of the thread. JVM calls the `run()` method of the thread.
- **`run()`**: Contains the code that is executed when the thread runs.
- **`sleep(long millis)`**: Causes the currently executing thread to sleep for the specified milliseconds.
- **`join()`**: Waits for the thread to die.
- **`yield()`**: Pauses the currently executing thread to allow other threads to execute.
- **`currentThread()`**: Returns a reference to the currently executing thread.
- **`getName()`**: Returns the name of the thread.
- **`setName(String name)`**: Sets the name of the thread.
- **`getId()`**: Returns the thread's ID.
- **`isAlive()`**: Tests if the thread is alive.
- **`getPriority()`**: Returns the thread's priority.
- **`setPriority(int priority)`**: Changes the priority of the thread (range: 1-10).
- **`interrupt()`**: Interrupts the thread. Runnable -> Blocked || Blocked -> Runnable
- **`isInterrupted()`**: Checks if the thread is interrupted.

#### Example of Thread class:
```java
class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
        System.out.println("Both threads have finished execution.");
    }
}
```

### 2. Implementing the Runnable Interface

The Runnable interface should be implemented by any class whose instances are intended to be executed by a thread.

#### Example:
```java
class MyRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " is running using Runnable");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }
    }
}

public class MainRunnable {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable, "Runnable Thread 1"); // can set name directly in Thread class.
        Thread t2 = new Thread(myRunnable, "Runnable Thread 2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("Both threads have finished execution using Runnable.");
    }
}
```

## Thread Life Cycle

The life cycle of a thread in Java goes through the following stages:

1. **New**: When a thread object is created but not yet started.
2. **Runnable**: After calling start(), the thread is in the runnable state.
3. **Blocked/Waiting**: A thread can be blocked or waiting for a resource.
4. **Terminated**: The thread finishes execution.

#### Example:
```java
class ThreadLifeCycle extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " running");
    }

    public static void main(String[] args) {
        ThreadLifeCycle t1 = new ThreadLifeCycle();
        System.out.println("Thread state before start: " + t1.getState());
        t1.start();
        System.out.println("Thread state after start: " + t1.getState());
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread state after completion: " + t1.getState());
    }
}
```

## Daemon Threads

Daemon threads are low-priority threads that run in the background to perform tasks like garbage collection.
-JVM will wait for user thread to complete although main thread is TERMINATED.
-JVM won't wait for Daemon thread to be in TERMINATED state. If main thread is terminated all Daemon thread will be terminated.

#### Example:
```java
class DaemonThread extends Thread {
    public void run() {
        if (Thread.currentThread().isDaemon()) {
            System.out.println(Thread.currentThread().getName() + " is Daemon thread");
        } else {
            System.out.println(Thread.currentThread().getName() + " is User thread");
        }
    }

    public static void main(String[] args) {
        DaemonThread t1 = new DaemonThread();
        DaemonThread t2 = new DaemonThread();

        t1.setDaemon(true);  // Setting t1 as daemon

        t1.start();
        t2.start();
    }
}
```

## Synchronization

Synchronization ensures that only one thread can access a resource at a time.
Using keyword `synchronized`.
Other thread will wait for one thread to complete synchronized task.
Other thread won't run until one thread terminates.

#### Example:
```java
class Table {
    synchronized void printTable(int n) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class Print extends Thread {
    private Table t;
    private int n;

    Print(Table t, int n) {
        this.t = t;
        this.n = n;
    }

    public void run() {
        t.printTable(n);
    }
}

public class TableSync {
    public static void main(String[] args) {
        Table obj = new Table();

        Print t1 = new Print(obj, 5);
        Print t2 = new Print(obj, 100);

        t1.start();
        t2.start();

        System.out.println("Main thread started");
    }
}
```

## Dis-advantages of using `synchronized` keyword
-If one thread takes more time then other threads can not access that method i.e. there is no time out mechanism.
-Ex: If writing in db is taking more time duw to slower internet connection then other thread has to wait, but we can use Locks to set time out so that other thread can execute it if one is taking too much time to complete. 

## Lock
Lock is interface. Implementation is given by `ReentrantLock` class.
Locks provide more flexibility than synchronized blocks. The ReentrantLock class allows explicit locking and unlocking.

### Methods in the `Lock` class

- **`lock()`**: Acquires the lock if available, blocking otherwise.
- **`unlock()`**: Releases the lock held by the current thread.
- **`tryLock()`**: Attempts to acquire the lock immediately, returning a boolean.
- **`tryLock(long time, TimeUnit unit)`**: Attempts to acquire the lock within a specified time.
- **`lockInterruptibly()`**: Acquires the lock unless interrupted.
- **`newCondition()`**: Returns a new `Condition` instance bound to this lock.

### Types of Locks:
1) Intrinsic Locks: Every object has intrinsic lock which will be used when using `synchronized`.
2) Explicit Locks: More advanced control over locks which can be controlled by Lock class.

#### Example:
```java
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

```

## Fairness in Lock

By default, locks are not fair. You can make a lock fair by passing `true` to the constructor of ReentrantLock.
-Thread which has requested first will execute first instead of randomness.
-First come first serve.
-Solves starvation problem.

```java
Lock lock = new ReentrantLock(true);  // Fair lock
```

## Read-Write Lock

The `ReadWriteLock` allows multiple threads to read a resource simultaneously, but only one thread can write.
-If write lock is acquired then reading has to wait for writing to be completed. 
#### Example:
```java
class ReadWriteExample {
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private int value = 0;

    public void write(int v) {
        rwLock.writeLock().lock();
        try {
            this.value = v;
            System.out.println("Written value: " + v);
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public void read() {
        rwLock.readLock().lock();
        try {
            System.out.println("Read value: " + value);
        } finally {
            rwLock.readLock().unlock();
        }
    }
}

class MainReadWrite {
    public static void main(String[] args) {
        ReadWriteExample obj = new ReadWriteExample();
        
        // Writing in one thread
        new Thread(() -> obj.write(42)).start();
        
        // Reading in multiple threads
        new Thread(() -> obj.read()).start();
        new Thread(() -> obj.read()).start();
    }
}
```
## Deadlock
A deadlock occurs when two or more threads are blocked forever, each waiting on the other.

### Solution : use `ReentrantLock` class.

**Example:**
```java
package Threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {
    private final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Deadlock d = new Deadlock();
        d.outerMethod();
    }

    public void outerMethod() {
        lock.lock();

        try {
            System.out.println("Inside outerMethod");
//            this will lead to deadlock as innerMethod depends on outerMethod lock to unlock and run innerMethod and 
//            innerMethod depends on outerMethod to unlock lock.

//            still works because of ReentrantLock -> Gives lock to whom it requires
            innerMethod();
        } finally {
            lock.unlock();
        }
    }

    public void innerMethod() {
        lock.lock();

        try {
            System.out.println("Inside innerMethod");
        } finally {
            lock.unlock();
        }
    }
}

```

## Thread Communication
Threads can communicate with each other using methods like wait(), notify(), and notifyAll().

Example:
```java
class Customer {
    int amount = 10000;

    synchronized void withdraw(int amount) {
        System.out.println("Going to withdraw...");
        if (this.amount < amount) {
            System.out.println("Not enough balance; waiting for deposit...");
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        this.amount -= amount;
        System.out.println("Withdrawal completed: " + amount);
    }

    synchronized void deposit(int amount) {
        System.out.println("Going to deposit...");
        this.amount += amount;
        System.out.println("Deposit completed: " + amount);
        notify();  // Notifying waiting thread
    }
}

public class ThreadCommunicationExample {
    public static void main(String[] args) {
        Customer c = new Customer();

        new Thread(() -> c.withdraw(15000)).start();
        new Thread(() -> c.deposit(10000)).start();
    }
}
```
## Thread Safety
Thread safety ensures that shared data remains consistent when accessed by multiple threads.

Example:
```java
class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

public class ThreadSafetyExample {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: " + counter.getCount());
    }
}
```
## Thread Using Lambda Function
Threads can be created using lambda functions to simplify the syntax.

Example:
```java
public class LambdaThreadExample {
    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread running using Lambda: " + i);
            }
        };

        Thread thread = new Thread(task);
        thread.start();
    }
}
```
## Thread Pooling
A thread pool manages multiple worker threads to execute tasks concurrently.

Example:
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " is executing a task");
            });
        }

        executor.shutdown();
    }
}
```
## CyclicBarrier
CyclicBarrier allows a set of threads to wait for each other to reach a common point before continuing.

Example:
```java
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
```
---