import java.util.ArrayDeque;
import java.util.Deque;

/**
 * StackUsingDeque
 */
public class StackUsingDeque {

    public static void main(String[] args) {

        Deque<String> dequeStack = new ArrayDeque();

        dequeStack.push("1");
        dequeStack.push("2");
        dequeStack.push("3");
        dequeStack.push("4");
        dequeStack.push("5");

        System.out.println(dequeStack.size());

        dequeStack.pop();

        System.out.println(dequeStack.peek());

        System.out.println(dequeStack.getLast());

        System.out.println(dequeStack.size());

        System.out.println(dequeStack.toString());
        ;
    }

}