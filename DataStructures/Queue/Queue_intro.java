import java.util.Queue;

public class Queue_intro {

    public static void main(String[] args) {

        Queue queueObj = new Queue(10);

        System.out.println(queueObj.add(10));
        System.out.println(queueObj.add(20));
        System.out.println(queueObj.add(30));
        System.out.println(queueObj.add(40));
        System.out.println(queueObj.add(50));

        System.out.println(queueObj.poll());

    }
}
