package src.LinkedList.Medium;

// 24. Swap Nodes in Pairs

public class L24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode start = head.next;
        ListNode curr = head;
        ListNode nextt = null;
        if (curr != null && curr.next != null) {
            nextt = curr.next.next;
            curr.next.next = curr;
        }
        curr.next = swapPairs(nextt);
        return start;
    }

    private void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.print("NULL");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4, null);
        L24 l = new L24();
        ListNode node = l.swapPairs(head);
        l.printList(node);
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)