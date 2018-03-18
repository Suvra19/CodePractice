public class NodeValue {

    static int GetNode(Node head,int n) {
        // This is a "method-only" submission.
        // You only need to complete this method.
       /* int size = 0;
        Node currNode = head;
        while (currNode != null) {
            size++;
            currNode = currNode.next;
        }
        currNode = head;
        for (int i = size - 1; i > n; i-- ) {
            currNode = currNode.next;
        }
        int result = currNode.data;
        return result;*/
        int index = 0;
        Node current = head;
        Node result = head;
        while(current != null)
        {
            current=current.next;
            if (index++>n)
            {
                result=result.next;
            }
        }
        return result.data;
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

       /* Node currNode = a1;
        while(currNode != null) {
            System.out.println(String.valueOf(currNode.data));
            currNode = currNode.next;
        }*/
        System.out.println(GetNode(a1, 2));
    }
}
