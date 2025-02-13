package src.LinkedList.Easy;

// 234. Palindrome Linked List

public class L234 {
    ListNode left;

    private boolean helper(ListNode right) {
        if (right == null)
            return true;
        boolean isp = helper(right.next);
        if (isp == false) return false;
        boolean isp1 = left.val == right.val ? true : false;
        left = left.next;
        return isp1;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        left = head;
        return helper(head);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1, null);
        L234 l = new L234();
        System.out.println(l.isPalindrome(head));
    }
}

// Time complexity - O(N)
// Space complexity - O(N)