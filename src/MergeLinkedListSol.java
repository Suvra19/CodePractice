public class MergeLinkedListSol {

    static Node mergeLists(Node headA, Node headB) {
        if (headA == null) {
            return headB;
        }
        if (headB == null) {
            return headA;
        }
        if (headA.data < headB.data) {
            headA.next = mergeLists(headA.next, headB);
            return headA;
        } else {
            headB.next = mergeLists(headA, headB.next);
            return headB;
        }
      /* Node headC = null;
       Node currentC = null;
       Node tempNode;
       while (headA != null && headB != null) {
           tempNode = new Node();
           if (headA.data < headB.data) {
               tempNode.data = headA.data;
               tempNode.next = null;
               if (headC != null) {
                   currentC.next = tempNode;
                   currentC = currentC.next;
               } else {
                   headC = tempNode;
                   currentC = headC;
               }
               headA = headA.next;
           } else {
               tempNode.data = headB.data;
               tempNode.next = null;
               if (headC != null) {
                   currentC.next = tempNode;
                   currentC = currentC.next;
               } else {
                   headC = tempNode;
                   currentC = headC;
               }
               headB = headB.next;
           }
       }
       if (headA != null) {
           currentC.next = headA;
       } else if (headB != null) {
           currentC.next = headB;
       }
       return headC;*/
    }

    public static void main(String[] args) {
        Node a1 = new Node();
        Node a2 = new Node();
        Node a3 = new Node();
        Node a4 = new Node();

        a1.data = 1;
        a1.next = a2;
        a2.data = 3;
        a2.next = a3;
        a3.data = 5;
        a3.next = a4;
        a4.data = 6;
        a4.next = null;

        /*a1.data = 15;
        a1.next = null;*/


        Node b1 = new Node();
        Node b2 = new Node();
        Node b3 = new Node();

        b1.data = 2;
        b1.next = b2;
        b2.data = 4;
        b2.next = b3;
        b3.data = 7;
        b3.next = null;

        /*b1.data = 1;
        b1.next = b2;
        b2.data = 2;
        b2.next = null;*/

        Node head = mergeLists(a1, b1);
        Node currNode = head;
        while(currNode != null) {
            System.out.println(String.valueOf(currNode.data));
            currNode = currNode.next;
        }
    }
}
