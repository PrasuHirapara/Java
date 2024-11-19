package Threading;

public class Main{

    static class MyThread extends Thread {

        MyThread() {
            super();
        }
        //    used to set name of thread
        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                try {
                    Thread.sleep(200); // Timed waiting
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    static class MyThread2 implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread1 = new MyThread("myThread1"); // new
        myThread1.start(); // runnable
        System.out.println(myThread1.getState());

        MyThread2 myThread2 = new MyThread2();
        Thread t1 = new Thread(myThread2, "t1");
        t1.start();

//        t1.setPriority(Thread.MAX_PRIORITY);
        t1.interrupt(); // stop doing what you are doing. Running -> Blocked
        t1.interrupt(); // Blocked -> Running
        System.out.println("This will run first although myThread should run first.");

        t1.join();
        myThread1.join();
        System.out.println(myThread1.getState()); // terminated

    }
}