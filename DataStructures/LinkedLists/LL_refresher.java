public class LL_refresher {

    // returns if empty
    private boolean isEmpty(Node head) {
        if (head.next == null) {
            return true;
        } else {
            return false;
        }
    }

    // Return size()
    private int size(Node head) {
        int count = 0;
        while (head.next != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    // SignlyLL populate
    private void populate(Node head) {

        Node temp_head = head;

        while (temp_head.data == null || temp_head.data <= 100) {
            if (temp_head.data == null) {
                temp_head.data = 0;
            }
            temp_head.next = new Node(temp_head.data + 10);
            temp_head = temp_head.next;
        }

    }

    // SignlyLL deletion
    private void delete(Node head, int target) {

        Node temp_head = head;

        while (temp_head.next != null) {

            if (temp_head.next.data == target) {
                temp_head.next = temp_head.next.next;
                break;
            }
            // System.out.println(temp_head.data);
            temp_head = temp_head.next;

        }
    }

    // Traverse
    public void traverse(Node head) {
        while (head.next != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static void main(String[] args) {

        LL_refresher obj = new LL_refresher();
        Node head = new Node();

        System.out.println(obj.isEmpty(head));
        obj.populate(head);
        System.out.println(obj.isEmpty(head));
        obj.delete(head, 60);
        System.out.println("size of the list is: " + obj.size(head));
        obj.traverse(head);

    }
}
