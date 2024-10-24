package Threading;

public class DaemonThread extends Thread {
    DaemonThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Printing");
        }
    }

    public static void main(String[] args) {
        DaemonThread dt = new DaemonThread("DaemonThread");
//        if main thread is terminated daemon will be terminated automatically.
        dt.setDaemon(true);
        dt.start();
        System.out.println("Main Done");
    }
}
