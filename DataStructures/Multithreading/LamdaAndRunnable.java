public class LamdaAndRunnable {

    public static void main(String[] args) {

        Thread thread_a = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("A: " + i);
            }
        });

        Thread thread_b = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("B: " + i);
            }
        });

        thread_a.start();
        thread_b.start();

    }

}