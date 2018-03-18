import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList2 {
    static Node Reverse(Node head) {
       /* Node currNode = head;
        List<Node> nodes = new ArrayList<>();
        while (currNode != null) {
            nodes.add(currNode);
            currNode = currNode.next;
        }
        if (nodes.size() > 0) {
            Node newHead = nodes.get(nodes.size() - 1);
            currNode = newHead;
            for (int i = nodes.size() - 2; i >= 0; i--) {
                Node temp = nodes.get(i);
                currNode.next = temp;
                currNode = temp;
            }
            currNode.next = null;
            return newHead;
        }
        return head;*/
       if (head == null || head.next == null) {
           return head;
       }
       Node newHead = Reverse(head.next);
       head.next.next = head;
       head.next = null;
       return newHead;
    }

    public static void main(String[] args) {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();

        n1.data = 1;
        n1.next = n2;
        n2.data = 2;
        n2.next = n3;
        n3.data = 3;
        n3.next = null;

        Node revNode =  Reverse(n1);
        Node next = revNode;
        while (next != null) {
            System.out.println(next.data);
            next = next.next;
        }
    }
}

