package PriorityQueue.Hard;

// 23. Merge k Sorted Lists

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class L23 {

    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue(k, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode start = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            dummy.next = node;
            dummy = dummy.next;
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return start.next;
    }

    private void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("NULL");
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(5, null);
        ListNode b = new ListNode(4, a);
        ListNode c = new ListNode(1, b);
        ListNode d = new ListNode(4, null);
        ListNode e = new ListNode(3, d);
        ListNode f = new ListNode(1, e);
        ListNode g = new ListNode(6, null);
        ListNode h = new ListNode(3, g);
        ListNode[] lists = {c, f, h};
        L23 l = new L23();
        ListNode ans = l.mergeKLists(lists);
        l.printList(ans);
    }
}

// Time Complexity - O(N * logK)
// Space Complexity - O(K)