package src.LinkedList.Hard;

// 25. Reverse Nodes in k-Group

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class L25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        ListNode nextt = null;
        int count = 0;
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }
        if (count == k) {
            curr = reverseKGroup(curr, k);
            while (count > 0) {
                nextt = head.next;
                head.next = curr;
                curr = head;
                head = nextt;
                count--;
            }
            head = curr;
        }
        return head;
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
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        L25 l = new L25();
        ListNode node = l.reverseKGroup(head, 3);
        l.printList(node);
    }
}

// Time complexity - O(N)
// Space complexity - O(1)