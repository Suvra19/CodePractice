public class DeleteDuplicateValueSol {
    static Node RemoveDuplicates(Node head) {
        /*if (head != null) {
            Node previousNode = head;
            Node currentNode = previousNode;
            while (currentNode != null && currentNode.next != null) {
                previousNode = currentNode;
                currentNode = currentNode.next;
                while (currentNode != null && currentNode.data == previousNode.data) {
                    previousNode.next = currentNode.next;
                    currentNode = currentNode.next;
                }
            }
        }*/
        if (head == null) {
            return head;
        }
        Node nextNode = head.next;
        while (nextNode != null && head.data == nextNode.data) {
            nextNode = nextNode.next;
        }
        head.next = RemoveDuplicates(nextNode);
        return head;
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
        a2.data = 1;
        a2.next = a3;
        a3.data = 3;
        a3.next = a4;
        a4.data = 3;
        a4.next = a5;
        a5.data = 3;
        a5.next = a6;
        a6.data = 3;
        a6.next = null;

       Node currNode = a1;
       while(currNode != null) {
            System.out.println(String.valueOf(currNode.data));
            currNode = currNode.next;
       }
       System.out.println();
       currNode = RemoveDuplicates(a1);
       while(currNode != null) {
           System.out.println(String.valueOf(currNode.data));
           currNode = currNode.next;
       }
    }
}
