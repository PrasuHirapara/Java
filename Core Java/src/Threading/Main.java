package Threading;

public class Main{
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