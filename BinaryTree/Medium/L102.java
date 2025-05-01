package BinaryTree.Medium;

// 102. Binary Tree Level Order Traversal

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class L102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                temp.add(node.val);
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            ans.add(temp);
        }
        return ans;
    }

    // L103
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Deque<TreeNode> dq = new LinkedList<>();
        dq.add(root);
        boolean isLeftToRight = true;

        while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> list = new ArrayList<>();
            if (isLeftToRight) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = dq.pollFirst();
                    list.add(node.val);
                    if (node.left != null)
                        dq.addLast(node.left);
                    if (node.right != null)
                        dq.addLast(node.right);
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = dq.pollLast();
                    list.add(node.val);
                    if (node.right != null)
                        dq.addFirst(node.right);
                    if (node.left != null)
                        dq.addFirst(node.left);
                }
            }
            isLeftToRight = !isLeftToRight;
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(15);
        TreeNode leafNode2 = new TreeNode(7);
        TreeNode leafNode3 = new TreeNode(9);
        TreeNode node1 = new TreeNode(20, leafNode1, leafNode2);
        TreeNode root = new TreeNode(3, leafNode3, node1);
        System.out.println(new L102().levelOrder(root));
        System.out.println(new L102().zigzagLevelOrder(root));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)