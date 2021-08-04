public class SignlyLL_Practice {
    
    Node head = new Node(10);

    public void append(int data){
        Node current = head;

        while(current.next != null){
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void prepend(int data){

        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void deleteWithValue(int target){
        Node current = head;
        while(current.next != null){
            if(current.next.data == target){
                current.next = current.next.next;
            }
            current = current.next;
        }
    }

    public void traverse(){
        Node current = head;
        while(current.next != null){
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println(current.data);
    }

    public static void main(String[] args) {
        
        SignlyLL_Practice obj = new SignlyLL_Practice();
        obj.append(20);
        obj.append(30);
        obj.append(40);
        obj.traverse();

    }
}
