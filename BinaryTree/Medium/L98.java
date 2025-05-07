package BinaryTree.Medium;

// 98. Validate Binary Search Tree

public class L98 {
    private boolean helper(TreeNode root, double minValue, double maxValue) {
        if (root == null)
            return true;
        if (root.val > minValue && root.val < maxValue && helper(root.left, minValue, root.val) && helper(root.right, root.val, maxValue))
            return true;
        return false;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(1);
        TreeNode leafNode2 = new TreeNode(3);
        TreeNode leafNode3 = new TreeNode(7);
        TreeNode node1 = new TreeNode(2, leafNode1, leafNode2);
        TreeNode root = new TreeNode(4, node1, leafNode3);
        System.out.println(new L98().isValidBST(root));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(H)