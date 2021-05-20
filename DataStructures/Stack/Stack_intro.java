import java.util.Stack;

/**
 * Stack_intro
 */
public class Stack_intro {

    public static void main(String[] args) {

        /**
         * Decalring stack Stack gets by default size of 10
         */
        Stack<String> stack = new Stack<>();

        /**
         * Pushing multiple elements using loop
         */
        for (int i = 0; i < 5; i++) {
            System.out.println("Pushed ".concat(stack.push(String.valueOf(i))));
        }

        /**
         * Searching element in stack if not found return -1 positions starts from 1 on
         * top of the stack
         */
        System.out.println("Search found on position " + stack.search("0"));

        /**
         * Emptying entire stack
         */
        while (!stack.empty()) {
            System.out.println("Popped: " + stack.pop());
        }

        /**
         * pushing single element
         */
        System.out.println("Pushed: " + stack.push("Shubham"));
        System.out.println("Pushed: " + stack.push("Rane"));

        /**
         * Popping single element
         */
        System.out.println("Popped: ".concat(stack.pop()));

        /**
         * Peek returns top most element on stack
         */
        System.out.println("Popped: ".concat(stack.peek()));

        /**
         * isCapacity method is from vector class and returns allocated capacity to the
         * stack this is by default 10 and increases by double i.e. 20 if 11 elements
         * are pushed in the stack
         */
        System.out.println("Capacity: ".concat(String.valueOf(stack.capacity())));
    }
}