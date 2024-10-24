
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
-JVM will won't wait for Daemon thread to be in TERMINATED state. If main thread is terminated all Daemon thread will be terminated.

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

## Locks

Locks provide more flexibility than synchronized blocks. The ReentrantLock class allows explicit locking and unlocking.

#### Example:
```java
class PrintNumbers {
    private final Lock lock = new ReentrantLock();

    public void print(int n) {
        lock.lock();
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println(n * i);
            }
        } finally {
            lock.unlock();
        }
    }
}

class LockThread extends Thread {
    PrintNumbers printNumbers;
    int num;

    LockThread(PrintNumbers pn, int num) {
        this.printNumbers = pn;
        this.num = num;
    }

    public void run() {
        printNumbers.print(num);
    }

    public static void main(String[] args) {
        PrintNumbers pn = new PrintNumbers();
        LockThread t1 = new LockThread(pn, 5);
        LockThread t2 = new LockThread(pn, 100);
        t1.start();
        t2.start();
    }
}
```

## Fairness in Lock

By default, locks are not fair. You can make a lock fair by passing `true` to the constructor of ReentrantLock.

```java
Lock lock = new ReentrantLock(true);  // Fair lock
```

## Read-Write Lock

The `ReadWriteLock` allows multiple threads to read a resource simultaneously, but only one thread can write.

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

**Example:**
```java
class Resource {
    synchronized void methodA(Resource b) {
        System.out.println(Thread.currentThread().getName() + " method A");
        b.methodB(this);  // Trying to call methodB of object b
    }

    synchronized void methodB(Resource a) {
        System.out.println(Thread.currentThread().getName() + " method B");
        a.methodA(this);  // Trying to call methodA of object a
    }
}

public class DeadlockExample {
    public static void main(String[] args) {
        Resource r1 = new Resource();
        Resource r2 = new Resource();

        new Thread(() -> r1.methodA(r2), "Thread 1").start();
        new Thread(() -> r2.methodB(r1), "Thread 2").start();
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