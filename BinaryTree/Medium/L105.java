package BinaryTree.Medium;

// 105. Construct Binary Tree from Preorder and Inorder Traversal

public class L105 {
    private static void printTree(TreeNode root) {
        if (root == null) return;
        printTree(root.left);
        System.out.println(root.val + " ");
        printTree(root.right);
    }

    private int findIndex(int[] inorder, int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == value)
                return i;
        }
        return -1;
    }

    int p;

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) return null;
        TreeNode node = new TreeNode(preorder[p++]);
        if (start == end)
            return node;
        int index = findIndex(inorder, start, end, node.val);
        node.left = buildTreeHelper(preorder, inorder, start, index - 1);
        node.right = buildTreeHelper(preorder, inorder, index + 1, end);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        p = 0;
        return buildTreeHelper(preorder, inorder, 0, preorder.length - 1);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        L105 obj = new L105();
        TreeNode root = obj.buildTree(preorder, inorder);
        obj.printTree(root);
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)