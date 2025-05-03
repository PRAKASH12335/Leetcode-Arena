package BinaryTree.Hard;

// 124. Binary Tree Maximum Path Sum

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

public class L124 {
    int maximumSum = Integer.MIN_VALUE;

    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int temp = Math.max(root.val, root.val + Math.max(left, right));
        int ans = Math.max(temp, left + right + root.val);
        maximumSum = Math.max(maximumSum, ans);
        return temp;
    }

    public int maxPathSum(TreeNode root) {
        helper(root);
        return maximumSum;
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(9);
        TreeNode leafNode2 = new TreeNode(15);
        TreeNode leafNode3 = new TreeNode(7);
        TreeNode node1 = new TreeNode(20, leafNode2, leafNode3);
        TreeNode root = new TreeNode(-10, leafNode1, node1);
        System.out.println(new L124().maxPathSum(root));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)