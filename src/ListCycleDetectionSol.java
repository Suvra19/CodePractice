import java.util.HashSet;
import java.util.Set;

public class ListCycleDetectionSol {

    static boolean hasCycle(Node head) {
        Set<Node> nodes = new HashSet<>();
        boolean isCycle = false;
        while (head != null && !isCycle) {
            if (!nodes.add(head)) {
                isCycle = true;
            }
            head = head.next;
        }
        return isCycle;
    }

    public static void main(String[] args) {
        Node a1 = new Node();
        Node a2 = new Node();
        Node a3 = new Node();
        Node a4 = new Node();
        Node a5 = new Node();
        Node a6 = new Node();

        a1.data = 1;
        a1.next = a2;
        a2.data = 2;
        a2.next = a3;
        a3.data = 3;
        a3.next = a4;
        a4.data = 3;
        a4.next = null;
        a5.data = 3;
        a5.next = a6;
        a6.data = 3;
        a6.next = null;

        /*Node currNode = a1;
        while(currNode != null) {
            System.out.println(String.valueOf(currNode.data));
            currNode = currNode.next;
        }*/
        System.out.println(a2 == a3.next);
        System.out.println();
        System.out.println(hasCycle(a1));
    }
}
