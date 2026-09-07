package src.LinkedList.Medium;

// 92. Reverse Linked List II

// Input : 1 -> 2 -> 3 -> 4 -> 5 -> NULL
// Output : 1 -> 4 -> 3 -> 2 -> 5 -> NULL

public class L92 {
    private void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.print("NULL");
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode prev = null;
        while (left > 1) {
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }
        ListNode conn = prev;
        ListNode tail = curr;
        while (right > 0) {
            ListNode next_next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next_next;
            right--;
        }
        if (conn != null) {
            conn.next = prev;
        } else {
            head = prev;
        }
        tail.next = curr;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        L92 obj = new L92();
        ListNode node = obj.reverseBetween(head, 2, 4);
        obj.printList(node);
    }
}

// Time complexity - O(N)
// Space complexity - O(1)