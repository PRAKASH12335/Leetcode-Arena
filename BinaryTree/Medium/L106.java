package BinaryTree.Medium;

// 106. Construct Binary Tree from Inorder and Postorder Traversal

public class L106 {
    private void printTree(TreeNode root) {
        if (root == null) return;
        printTree(root.left);
        System.out.println(root.val + " ");
        printTree(root.right);
    }

    int p;

    private TreeNode buildTree(int[] inorder, int[] postorder) {
        p = postorder.length - 1;
        return helper(inorder, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(postorder[p--]);
        if (start == end) return root;
        int index = findIndex(inorder, start, end, root.val);
        root.right = helper(inorder, postorder, index + 1, end);
        root.left = helper(inorder, postorder, start, index - 1);
        return root;
    }

    private int findIndex(int[] inorder, int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == value)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        L106 obj = new L106();
        TreeNode root = obj.buildTree(inorder, postorder);
        obj.printTree(root);
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)