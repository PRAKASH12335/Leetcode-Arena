package Striver;

// Ceil in a Binary Search Tree

public class CeilInBST {
    private int findCeil(TreeNode root, int target) {
        int ceil = -1;
        while (root != null) {
            if (root.val == target) {
                ceil = root.val;
                return ceil;
            }
            if (root.val > target) {
                ceil = root.val;
                root = root.left;
            } else
                root = root.right;
        }
        return ceil;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(13);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.right = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);
        int ceil = new CeilInBST().findCeil(root, 8);
        System.out.println(ceil);
    }
}

// Time Complexity - O(log N)
// Space Complexity - O(1)