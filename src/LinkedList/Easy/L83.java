package src.LinkedList.Easy;

// 83. Remove Duplicates from Sorted List

public class L83 {
    private void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + "->");
            node = node.next;
        }
        System.out.println("NULL");
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                ListNode p = head.next.next;
                if (p == null) {
                    head.next = null;
                    return temp;
                }
                head.next = p;
            } else {
                head = head.next;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next = new ListNode(4);
        L83 obj = new L83();
        ListNode node = obj.deleteDuplicates(head);
        obj.printList(node);
    }
}

// Time complexity - O(N)
// Space complexity - O(1)