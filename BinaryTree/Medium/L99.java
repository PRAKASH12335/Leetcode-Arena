package BinaryTree.Medium;

// 99. Recover Binary Search Tree

public class L99 {
    TreeNode first, middle, last, prev;

    private static void printTree(TreeNode root) {
        if (root == null) return;
        printTree(root.left);
        System.out.println(root.val + " ");
        printTree(root.right);
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
                middle = root;
            } else
                last = root;
        } else
            prev = root;
        helper(root.right);
    }

    public void recoverTree(TreeNode root) {
        first = middle = last = prev = null;
        helper(root);
        int temp;
        if (first != null && last != null) {
            temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if (first != null && middle != null) {
            temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(1);
        TreeNode leafNode2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(4, leafNode2, null);
        TreeNode root = new TreeNode(3, leafNode1, node1);
        L99 obj = new L99();
        obj.printTree(root);
        obj.recoverTree(root);
        System.out.println("Afer Recovery");
        obj.printTree(root);
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)