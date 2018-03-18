public class ReverseLinkedList {
    static void reversePrint(Node head) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        if (head != null) {
            reversePrint(head.next);
            System.out.println(head.data);
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();

        node1.data = 2;
        node1.next = node2;

        node2.data = 1;
        node2.next = node3;

        node3.data = 4;
        node3.next = node4;

   ;    node4.data = 5;
        node4.next = null;

        reversePrint(node1);

    }
}
