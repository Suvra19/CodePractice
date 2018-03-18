import javax.jws.soap.SOAPBinding;

public class ReverseDoublyLinkedList {

    static Node Reverse(Node head) {
        if (head.next == null) {
            head.prev = null;
            return head;
        }
        Node revHead = Reverse(head.next);
        Node current = revHead;
        while (current.next != null) {
            current = current.next;
        }
        current.next = head;
        head.prev = current;
        head.next = null;
        return revHead;
    }

    public static void main(String[] args) {
        Node a1 = new Node();
        Node a2 = new Node();
        Node a3 = new Node();
        Node a4 = new Node();
        Node a5 = new Node();
        Node a6 = new Node();

        a1.data = 2;
        a1.prev = null;
        a1.next = a2;
        a2.data = 4;
        a2.next = a3;
        a2.prev = a1;
        a3.data = 6;
        a3.next = null;
        a3.prev = a2;

        Node currNode = a1;
        while(currNode != null) {
            System.out.println(String.valueOf(currNode.data));
            currNode = currNode.next;
        }
        System.out.println();
       currNode = Reverse(a1);
       while(currNode != null) {
            System.out.println(String.valueOf(currNode.data));
            currNode = currNode.next;
        }

    }
}
