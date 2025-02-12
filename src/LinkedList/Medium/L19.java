package src.LinkedList.Medium;

// 19. Remove Nth Node From End of List

public class L19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        if (n == 0)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
            if (fast == null)
                return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("NULL");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        L19 l = new L19();
        ListNode node = l.removeNthFromEnd(head, 2);
        l.printList(node);
    }
}

// Time complexity - O(N)
// Space complexity - O(1)