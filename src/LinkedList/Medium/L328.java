package src.LinkedList.Medium;

// 328. Odd Even Linked List

public class L328 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode temp = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = temp;
        return head;
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
        L328 l = new L328();
        ListNode node = l.oddEvenList(head);
        l.printList(node);
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)