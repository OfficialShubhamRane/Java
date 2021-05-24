class Counter {
    int count = 0;

    public synchronized void increment() {
        count++;
    }
}

public class ThreadSynchronization {

    public static void main(String[] args) throws InterruptedException {

        Counter c = new Counter();

        Thread x = new Thread(() -> {

            for (int i = 0; i < 1000; i++) {
                c.increment();
            }

        });

        Thread y = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                c.increment();
            }
        });

        x.start();
        y.start();

        x.join();
        y.join();

        System.out.println("Count: " + c.count);
    }
}
