public class LL_refresher {

    public static void main(String[] args) {

        Node head = new Node(10);
        Node temp_head = head;

        // SinglyLL insertion
        while (temp_head.data <= 100) {
            temp_head.next = new Node(temp_head.data + 10);
            temp_head = temp_head.next;
        }
        temp_head = head; // reseting temp_head for future operations and reuse

        // // Traversal
        // while (head.next != null) {
        // System.out.println(head.data);
        // head = head.next;
        // }

        // SignlyLL deletion
        int target = 40;
        while (temp_head.next != null) {

            if (temp_head.next.data == target) {
                temp_head.next = temp_head.next.next;
                break;
            }
            // System.out.println(temp_head.data);
            temp_head = temp_head.next;

        }

        // Traversal
        while (head.next != null) {
            System.out.println(head.data);
            head = head.next;
        }

    }
}
