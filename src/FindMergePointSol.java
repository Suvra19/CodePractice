public class FindMergePointSol {

    static int FindMergeNode(Node headA, Node headB) {
        /*Node startHeadA = headA.next;
        Node startHeadB = headB.next;
        int result = -1;
        boolean found = false;
        while(!found) {
            if(startHeadA.data == startHeadB.data) {
                result = startHeadA.data;
                found = true;
            } else {
                startHeadA = startHeadA.next;
                if (startHeadA == null) {
                    startHeadA = headA.next;
                    startHeadB = startHeadB.next;
                }
            }
        }
        return result;*/
        Node currentA = headA;
        Node currentB = headB;

        while (currentA != currentB) {
            if(currentA.next == null) {
                currentA = headB;
            } else {
                currentA = currentA.next;
            }

            if (currentB.next == null) {
                currentB = headA;
            } else {
                currentB = currentB.next;
            }
        }
        return currentA.data;
    }

    public static void main(String[] args) {
        Node a1 = new Node();
        Node a2 = new Node();
        Node a3 = new Node();
        Node a4 = new Node();

        Node c3 = new Node();
        c3.data = 3;
        c3.next = null;

        a1.data = 1;
        a1.next = a2;
        a2.data = 2;
        a2.next = c3;

        a3.data = 3;
        a3.next = null;


        a4.data = 6;
        a4.next = null;

        /*a1.data = 15;
        a1.next = null;*/


        Node b1 = new Node();
        Node b2 = new Node();
        Node b3 = new Node();

        b1.data = 1;
        b1.next = c3;

        b2.data = 3;
        b2.next = null;
        b3.data = 3;
        b3.next = null;

        /*b1.data = 1;
        b1.next = b2;
        b2.data = 2;
        b2.next = null;*/

       // Node head = mergeLists(a1, b1);
        Node currNode = a1;
        while(currNode != null) {
            System.out.println(String.valueOf(currNode.data));
            currNode = currNode.next;
        }
        System.out.println();
        currNode = b1;
        while(currNode != null) {
            System.out.println(String.valueOf(currNode.data));
            currNode = currNode.next;
        }
        System.out.println();
        int mergePoint = FindMergeNode(a1, b1);
        System.out.println(mergePoint);
    }
}
