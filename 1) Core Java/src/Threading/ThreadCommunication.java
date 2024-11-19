package Threading;

public class ThreadCommunication {

    static class ItemQueue {
        private int item;
        private boolean available = false;

        public synchronized void produce(int item) {
            while (available) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            this.item = item;
            available = true;
            System.out.println("Produced: " + item);
            notify();
        }

        public synchronized int consume() {
            while (!available) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            available = false;
            System.out.println("Consumed: " + item);
            notify();

            return item;
        }
    }

    static class Producer extends Thread {
        private final ItemQueue queue;

        Producer(ItemQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                queue.produce(i);
            }
        }
    }

    static class Consumer extends Thread {
        private final ItemQueue queue;

        Consumer(ItemQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                queue.consume();
            }
        }
    }

    public static void main(String[] args) {
        ItemQueue queue = new ItemQueue();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        producer.start();
        consumer.start();
    }
}