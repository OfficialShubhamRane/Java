public class Singly_Linked_List {
    
    Singly_Node head;

    /** Appending node in the end */
    public void append( Object value){

        Singly_Node current = head;
        if(head == null){
            head = new Singly_Node(value);
            return;
        }
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Singly_Node(value);

    }

    /** Prepending node in the start */
    public void prepend(Object value){
        Singly_Node current;
    
        current = new Singly_Node( value );
        current.next = head;
        head = current; 

    }

    /** Deleting node with a particular value */
    public void deleteWithValue(Object value){
        
        if(head == null){return ;}

        if(head.data == value){
            head = head.next;
            return;  
        }

        Singly_Node current = head;
        while( current.next != null){
            if( current.next.data == value ){
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Singly_Node head = new Singly_Node(10);
        
    }

}   
