import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

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

    // SinglyLL insertions
    private void insert(int value, Node head) {

        Node temp_head = head;
        Node tobeInserted = new Node(value);

        while (temp_head.next != null) {
            if (temp_head.data <= value && temp_head.next.data > value) {
                tobeInserted.next = temp_head.next;
                temp_head.next = tobeInserted;
                break;
            }
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

        System.out.println("Is list empty: " + obj.isEmpty(head));
        obj.populate(head);
        obj.delete(head, 10);
        System.out.println("size of the list is: " + obj.size(head));
        obj.insert(10, head);
        obj.traverse(head);

    }
}
