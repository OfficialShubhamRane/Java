class DataClass {

    int data;
    boolean valueSet = false;

    public synchronized void put(int data) {

        while (valueSet) {
            try {
                wait();
            } catch (Exception e) {
            }
        }

        System.out.println("Put: " + data);
        this.data = data;
        valueSet = true;
        notify();
    }

    public synchronized void get() {

        while (!valueSet) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        System.out.println("Get: " + data);
        valueSet = false;
        notify();
    }
}

class Producer implements Runnable {

    DataClass dataObj;

    public Producer(DataClass dataObj) {
        this.dataObj = dataObj;
        Thread t = new Thread(this, "Producer Thread");
        t.start();

    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            dataObj.put(i++);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {

    DataClass dataObj;

    public Consumer(DataClass dataObj) {
        this.dataObj = dataObj;
        Thread t = new Thread(this, "Consumer Thread");
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            dataObj.get();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class InterThreadComm {

    public static void main(String[] args) {

        DataClass dataObj = new DataClass();
        new Producer(dataObj);
        new Consumer(dataObj);
    }

}
