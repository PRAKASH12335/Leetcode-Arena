package src.LinkedList.Easy;

// 206. Reverse Linked List

public class L206 {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode curr = head;
        ListNode prev = null;
        ListNode nextt = null;
        while (curr != null) {
            nextt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextt;
        }
        return prev;
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
        L206 l = new L206();
        ListNode node = l.reverseList(head);
        l.printList(node);
    }
}

// Time complexity - O(N)
// Space complexity - O(1)