public class StackUsingLL {

    SinglyNode head;
    int pointer = -1;
    public boolean prepend_push( int data){
        
        try {
            SinglyNode current;
            current = head;

            SinglyNode newNode = new SinglyNode(data);
            newNode.next = head;
            head = newNode;

            System.out.println("Stacked: " + data);
            pointer++;
            return true;
        } catch (Exception e) {
            System.err.println("Could not stack new node.");
            return false;
        }
    }

    public int delete_pop(){
   
        try {
            int poppedValue = head.data;
            head = head.next;
            pointer--;
            System.out.println("Popped: " + poppedValue);
            return poppedValue;
        } catch (NullPointerException e) {
            System.err.println("Stack is empty!!!");
            return Integer.MIN_VALUE;
        }
    }

    public int traverse_peep(){
        
        try {
            System.out.println("Peeped: " + head.data);
            return head.data;
        } catch (NullPointerException e) {
            System.err.println("Stack is empty!!!");
            return Integer.MIN_VALUE;
        }
    }

    public boolean isEmpty(){
        boolean isEmpty = (pointer < 0) ? true : false;
        System.err.println("Is stack empty?: " + isEmpty);
        return isEmpty;
    }
    
    
    public static void main(String[] args) {
        StackUsingLL obj = new StackUsingLL();

        obj.isEmpty();
        obj.prepend_push(10);
        obj.prepend_push(20);
        obj.prepend_push(30);
        obj.prepend_push(40);
        obj.prepend_push(50);

        obj.traverse_peep();
        obj.delete_pop();
        obj.traverse_peep();
        obj.delete_pop();
        obj.delete_pop();
        obj.delete_pop();
        obj.isEmpty();
        obj.delete_pop();
        obj.isEmpty();
        obj.delete_pop();


    }
}
