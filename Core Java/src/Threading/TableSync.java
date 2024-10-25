package Threading;

public class TableSync {

    static class Table {
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

    static class Print extends Thread {
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

    public static void main(String[] args) {
        Table obj = new Table();

        Print t1 = new Print(obj, 5);
        Print t2 = new Print(obj, 100);

        t1.start();
        t2.start();

        System.out.println("Main thread started");
    }
}