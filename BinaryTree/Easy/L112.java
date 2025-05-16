package BinaryTree.Easy;

// 112. Path Sum

public class L112 {
    private boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if (root.val == targetSum && root.left == null && root.right == null)
            return true;
        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);
        return left || right;
    }

    public static void main(String[] args) {

        TreeNode leafNode1 = new TreeNode(7);
        TreeNode leafNode2 = new TreeNode(2);
        TreeNode leafNode3 = new TreeNode(13);
        TreeNode leafNode4 = new TreeNode(1);
        TreeNode node1 = new TreeNode(11, leafNode1, leafNode2);
        TreeNode node2 = new TreeNode(4, null, leafNode4);
        TreeNode node3 = new TreeNode(8, leafNode3, node2);
        TreeNode node4 = new TreeNode(4, node1, node2);
        TreeNode root = new TreeNode(5, node4, node3);
        System.out.println(new L112().hasPathSum(root, 22));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(H)