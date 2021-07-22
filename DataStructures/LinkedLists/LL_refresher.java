import java.net.Socket;

public class LL_refresher {

    public static void main(String[] args) {

        Node head = new Node(10);
        Node temp_head = head;

        int i = 0;
        while (head.data <= 100) {
            // System.out.println(i);
            head.next = new Node(head.data + 10);
            // System.out.println(head.data);
            head = head.next;
            i++;
        }

        while (temp_head.next != null) {
            System.out.println(temp_head.data);
            temp_head = temp_head.next;
        }
    }
}
