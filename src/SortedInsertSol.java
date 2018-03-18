public class SortedInsertSol {

    static Node SortedInsert(Node head,int data) {
       /* Node newNode = new Node();
        newNode.data = data;
        if (head == null) {
            head = newNode;
            newNode.prev = null;
            newNode.next = null;
        } else {
            Node current = head;
            Node previous = head;
            while(current != null && current.data < data) {
                previous = current;
                current = current.next;
            }
            if (current != null && current.prev == null) {
               newNode.next = current;
               current.prev = newNode;
               head = newNode;
            } else {
                previous.next = newNode;
                newNode.prev = previous;
                newNode.next = current;
                if (current != null) {
                    current.prev = newNode;
                }

            }
        }
        return head;*/
       if (head == null) {
           Node newNode = new Node();
           newNode.data = data;
           return newNode;
       } else if (data <= head.data) {
           Node newNode = new Node();
           newNode.data = data;
           newNode.next = head;
           head.prev = newNode;
           return newNode;
       } else {
           Node rest = SortedInsert(head.next, data);
           head.next = rest;
           rest.prev = head;
           return head;
       }
    }

    public static void main(String[] args) {
        Node a1 = null;

        Node head = SortedInsert(a1, 2);
        Node currNode = head;
        while(currNode != null) {
            System.out.println(String.valueOf(currNode.data));
            currNode = currNode.next;
        }
        System.out.println();
        head = SortedInsert(head, 1);
        currNode = head;
        while(currNode != null) {
            System.out.println(String.valueOf(currNode.data));
            currNode = currNode.next;
        }
        System.out.println();
        head = SortedInsert(head, 4);
        currNode = head;
        while(currNode != null) {
            System.out.println(String.valueOf(currNode.data));
            currNode = currNode.next;
        }
        System.out.println();
        head = SortedInsert(head, 3);
        currNode = head;
        while(currNode != null) {
            System.out.println(String.valueOf(currNode.data));
            currNode = currNode.next;
        }
    }

}
