public class SinglyLL_insertion {

    public static void main(String[] args) {

        Singly_Node head = new Singly_Node();

        /** Declaring and initializing at same time in a loop */
        for (int i = 0; i < 10; i++) {

            // System.out.println(head + " " + first);
            Singly_Node node = new Singly_Node(String.valueOf(i));
            // System.out.println(node + " " + i);
            head.next = node;
            node = head;

        }

        /** Manual insertion at the end */
        Singly_Node newNode = new Singly_Node("10");
        head.next = newNode;
        head = newNode;
        System.out.println(head.data);

    }

}
