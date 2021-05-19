class LL_intro {

    public static void main(String[] args) {

        /** Declaring and initializing Nodes */
        Singly_Node head = new Singly_Node("1");
        Singly_Node second = new Singly_Node("2");
        Singly_Node third = new Singly_Node("3");
        Singly_Node forth = new Singly_Node("4");

        /** Linking Nodes */
        head.next = second;
        second.next = third;
        third.next = forth;

        /** Traversing Nodes */
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }

    }

}