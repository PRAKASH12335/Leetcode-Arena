package BinaryTree.Medium;

// 116. Populating Next Right Pointers in Each Node

import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class L116 {
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Node curr = q.poll();
                if (size != 0)
                    curr.next = q.peek();
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node leafNode1 = new Node(4, null, null, null);
        Node leafNode2 = new Node(5, null, null, null);
        Node leafNode4 = new Node(7, null, null, null);
        Node leafNode3 = new Node(3, null, leafNode4, null);
        Node node1 = new Node(2, leafNode1, leafNode2, null);
        Node root = new Node(1, node1, leafNode3, null);
        L116 obj = new L116();
        obj.connect(root);
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)