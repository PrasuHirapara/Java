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
