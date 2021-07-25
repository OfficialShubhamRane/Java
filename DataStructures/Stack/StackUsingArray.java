public class StackUsingArray extends Stack {

    public StackUsingArray(Integer[] arr2) {
        super(arr2);
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {

        Integer[] arr = new Integer[10];
        Stack stackArr = new Stack(arr);

        stackArr.push(0);
        stackArr.push(1);
        stackArr.push(2);
        stackArr.push(3);
        stackArr.push(4);
        stackArr.peek();
        stackArr.pop();
        stackArr.peek();

    }

}

class Stack {

    Integer[] arr;
    int pointer = -1;

    public Stack(Integer[] arr2) {
        this.arr = arr2;
    }

    public void push(int data) {
        pointer++;
        arr[pointer] = data;

    }

    public void peek() {
        System.out.println(arr[pointer]);
    }

    public void pop() {
        arr[pointer] = null;
        pointer--;
    }

}