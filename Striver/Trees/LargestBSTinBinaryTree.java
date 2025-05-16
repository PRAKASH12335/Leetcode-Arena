package Striver.Trees;

// Largest BST in Binary Tree

class Node {
    int minValue;
    int maxValue;
    int maxSize;

    Node(int minValue, int maxValue, int maxSize) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.maxSize = maxSize;
    }
}

public class LargestBSTinBinaryTree {
    private Node helper(TreeNode root) {
        if (root == null)
            return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        Node l = helper(root.left);
        Node r = helper(root.right);
        if (l.maxValue < root.val && root.val < r.minValue) {
            return new Node(Math.min(root.val, l.minValue), Math.max(root.val, r.maxValue), l.maxSize + r.maxSize + 1);
        }
        return new Node(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(l.maxSize, r.maxSize));
    }

    private int largestBST(TreeNode root) {
        return helper(root).maxSize;
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(17);
        TreeNode leafNode2 = new TreeNode(16);
        TreeNode leafNode3 = new TreeNode(19);
        TreeNode leafNode4 = new TreeNode(30);
        TreeNode leafNode5 = new TreeNode(50);
        TreeNode node1 = new TreeNode(60, leafNode5, null);
        TreeNode node2 = new TreeNode(40, leafNode4, node1);
        TreeNode node3 = new TreeNode(18, leafNode2, leafNode3);
        TreeNode node4 = new TreeNode(14, null, leafNode1);
        TreeNode node5 = new TreeNode(15, node4, node3);
        TreeNode root = new TreeNode(20, node5, node2);
        System.out.println(new LargestBSTinBinaryTree().largestBST(root));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)