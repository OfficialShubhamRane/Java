public class Into_to_threading {

    public static void main(String[] args) {
        A obj_A = new A();
        B obj_B = new B();
        Thread x = new Thread(obj_B);

        obj_A.start();
        x.start();
    }

}

class A extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("A: ".concat(String.valueOf(i)));
        }
    }

}

class B implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("B: ".concat(String.valueOf(i)));
        }
    }
}