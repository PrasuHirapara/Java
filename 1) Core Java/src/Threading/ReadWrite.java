package Threading;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWrite {

    static class DataBase {
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

    public static void main(String[] args) {
        DataBase db = new DataBase();

        // Writing in one thread
        new Thread(() -> db.write(42)).start();

        // Reading in multiple threads
        new Thread(() -> db.read()).start();
        new Thread(() -> db.read()).start();
    }
}