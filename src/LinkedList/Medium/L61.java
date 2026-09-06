package src.LinkedList.Medium;

// 61. Rotate List

// Input : 1 -> 2 -> 3 -> 4 -> 5 -> NULL
// Output : 4 -> 5 -> 1 -> 2 -> 3 -> NULL

public class L61 {
    private void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.print("NULL");
    }

    private int length(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public ListNode rotateRight(ListNode head, int k) {
        int len = length(head);
        if (len == 0) return head;
        k = k % len;
        if (k == 0) return head;

        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < k; i++) {
            first = first.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        ListNode start = second.next;
        first.next = head;
        second.next = null;
        return start;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        L61 obj = new L61();
        ListNode node = obj.rotateRight(head, 7);
        obj.printList(node);
    }
}

// Time complexity - O(N)
// Space complexity - O(1)