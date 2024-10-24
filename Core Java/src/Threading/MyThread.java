package Threading;

public class MyThread extends Thread {

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
