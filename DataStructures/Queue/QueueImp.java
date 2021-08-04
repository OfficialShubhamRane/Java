public class QueueImp {

    class QueueNode{
        int data;
        QueueNode next;

        public QueueNode(int data){
            this.data = data;
        }
    }

    private QueueNode head;
    private QueueNode tail;

    public void push( int data){
        QueueNode newNode = new QueueNode(data);
        if(tail != null){
            tail.next = newNode;  
        }
        tail = newNode;
        if(head == null){
            head = newNode;
        }
        
    }

    public int pop(){
        int result = head.data;
        head = head.next;
        return result;
    }

    public int peek(){
        return head.data;
    }

    public boolean isEmpty(){
        return head == null;
    }
    
    public static void main(String[] args) {
        QueueImp obj = new QueueImp();
        System.out.println(obj.isEmpty());
        obj.push(10);
        obj.push(20);
        obj.push(30);
        obj.push(40);
        obj.push(50);
        System.out.println( obj.peek());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.isEmpty());

    }
}