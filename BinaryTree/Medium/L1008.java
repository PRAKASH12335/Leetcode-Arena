package BinaryTree.Medium;

// 1008. Construct Binary Search Tree from Preorder Traversal

public class L1008 {
    private void printTree(TreeNode root) {
        if (root == null)
            return;
        printTree(root.left);
        System.out.println(root.val);
        printTree(root.right);
    }

    int order = 0;

    private TreeNode helper(int[] preorder, double minValue, double maxValue) {
        if (preorder.length == order)
            return null;
        if (preorder[order] > maxValue || preorder[order] < minValue)
            return null;
        TreeNode root = new TreeNode(preorder[order++]);
        root.left = helper(preorder, minValue, root.val);
        root.right = helper(preorder, root.val, maxValue);
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public static void main(String[] args) {
        int[] preorder = {8, 5, 1, 7, 10, 12};
        L1008 obj = new L1008();
        TreeNode ans = obj.bstFromPreorder(preorder);
        obj.printTree(ans);
    }
}

// Time Complexity - O(N)
// Space Complexity - O(H)