package src.LinkedList.Easy;

// 1290. Convert Binary Number in a Linked List to Integer

public class L1290 {
    public int getDecimalValue(ListNode head) {
        int sum = 0;
        while (head != null) {
            sum = (sum << 1) + head.val;
            head = head.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);
        System.out.println(new L1290().getDecimalValue(head));
    }
}

// Time complexity - O(N)
// Space complexity - O(1)