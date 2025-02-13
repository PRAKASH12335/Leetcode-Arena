package src.LinkedList.Medium;

import src.LinkedList.Easy.L206;

public class L237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        L237 l = new L237();
        l.deleteNode(head.next.next.next);
        l.printList(head);
    }
}

// Time Complexity - O(1)
// Space Complexity - O(1)