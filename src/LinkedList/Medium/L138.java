package src.LinkedList.Medium;

// 138. Copy List with Random Pointer

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
        this.random = null;
    }
}

public class L138 {

    public Node copyRandomList2(Node head) {
        if (head == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node newNode = map.get(curr);
            newNode.next = map.get(curr.next);
            newNode.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }

    // Time Complexity - O(N)
    // Space Complexity - O(1)

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node A = head;
        while (A != null) {
            Node nextt = A.next;
            Node temp = new Node(A.val);
            A.next = temp;
            temp.next = nextt;
            A = A.next.next;
        }
        A = head;
        while (A.next != null) {
            A.next.random = A.random != null ? A.random.next : A.random;
            A = A.next.next != null ? A.next.next : A.next;
        }

        Node original = head;
        Node copy = head.next;
        Node clone = copy;
        while (original != null && copy != null) {
            original.next = original.next != null ? original.next.next : original.next;
            original = original.next;
            copy.next = copy.next != null ? copy.next.next : copy.next;
            copy = copy.next;
        }
        return clone;
    }

    public void printList(Node node) {
        Node curr = node;
        while (curr.next != null) {
            System.out.print(curr.val);
            System.out.println(" next :" + curr.next.val);
            if (curr.random != null)
                System.out.println("random :" + curr.random.val);
            else
                System.out.println("random : null");
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(10, node1);
        Node node3 = new Node(11, node2);
        Node node4 = new Node(13, node3);
        Node head = new Node(7, node4);
        node1.random = head;
        node2.random = node3;
        node3.random = node1;
        node4.random = head;
        head.random = null;
        L138 l = new L138();
//        Node node = l.copyRandomList2(head);
        Node node = l.copyRandomList2(head);
        l.printList(node);
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)