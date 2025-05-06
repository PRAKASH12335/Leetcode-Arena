package BinaryTree.Medium;

// 662. Maximum Width of Binary Tree

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    TreeNode node;
    int position;

    Pair(TreeNode node, int position) {
        this.node = node;
        this.position = position;
    }
}

public class L662 {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        int ans = 0, first = 0, last = 0;
        if (root == null)
            return 0;
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                TreeNode node = p.node;
                int num = p.position;
                if (i == 0) first = num;
                if (i == size - 1) last = num;
                if (node.left != null) {
                    q.add(new Pair(node.left, 2 * num + 1));
                }
                if (node.right != null) {
                    q.add(new Pair(node.right, 2 * num + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(40);
        TreeNode leafNode2 = new TreeNode(60);
        TreeNode leafNode3 = new TreeNode(90);
        TreeNode leafNode4 = new TreeNode(100);
        TreeNode node1 = new TreeNode(20, leafNode1, leafNode2);
        TreeNode node2 = new TreeNode(30, leafNode3, leafNode4);
        TreeNode root = new TreeNode(10, node1, node2);
        System.out.println(new L662().widthOfBinaryTree(root));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)