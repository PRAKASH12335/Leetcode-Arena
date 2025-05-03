package BinaryTree.Easy;

// 543. Diameter of Binary Tree

public class L543 {
    int diameter = 0;

    public int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(5);
        TreeNode leafNode2 = new TreeNode(6);
        TreeNode leafNode3 = new TreeNode(3);
        TreeNode leafNode4 = new TreeNode(7);
        TreeNode node1 = new TreeNode(4, leafNode1, leafNode2);
        TreeNode node2 = new TreeNode(2, leafNode3, node1);
        TreeNode root = new TreeNode(1, node2, leafNode4);
        System.out.println(new L543().diameterOfBinaryTree(root));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)