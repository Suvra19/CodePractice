public class CompareLinkedList {
    static int CompareLists(Node headA, Node headB) {
        // This is a "method-only" submission.
        // You only need to complete this method
        if (headA == null || headB == null) {
            return 0;
        }
        boolean ok = true;
        while (headA != null && headB != null && ok) {
            if ((headA.next == null && headB.next != null) || (headA.next != null && headB.next == null) ) {
                ok = false;
            }
            if (!(headA.data == headB.data)) {
                ok = false;
            }
            headA = headA.next;
            headB = headB.next;
        }

        if (ok) {
            return 1;
        } else {
            return 0;
        }
    }
    public static void main(String[] args) {
       // Node a = createNewList(1, 2, 3);
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();

        n1.data = 1;
        n1.next = n2;
        n2.data = 2;
        n2.next = n3;
        n3.data = 3;
        n3.next = null;

        Node b1 = new Node();
        Node b2 = new Node();
        Node b3 = new Node();

        b1.data = 1;
        b1.next = b2;
        b2.data = 2;
        b2.next = null;
    /*    b3.data = 3;
        b3.next = null;*/

        System.out.println(CompareLists(n1, b1));

    }

    /*private static Node createNewList(int... values) {
        for (int i : values) {
            Node n = new Node();
            n.data = i;
        }
    }*/
}
