package Striver;

// Boundary Traversal of binary tree

import java.util.ArrayList;
import java.util.List;

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

public class BoundaryTraversalOfTree {
    private void leftOrderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null || root.left == null && root.right == null)
            return;
        ans.add(root.val);
        if (root.left != null)
            leftOrderTraversal(root.left, ans);
        else if (root.right != null)
            leftOrderTraversal(root.right, ans);
    }

    private void leafTraversal(TreeNode root, List<Integer> ans) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            ans.add(root.val);
        leafTraversal(root.left, ans);
        leafTraversal(root.right, ans);
    }

    private void rightOrderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null || root.left == null && root.right == null)
            return;
        if (root.right != null)
            leftOrderTraversal(root.right, ans);
        else if (root.left != null)
            leftOrderTraversal(root.left, ans);
        ans.add(root.val);
    }

    private List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        if (root.left != null && root.right != null)
            ans.add(root.val);
        leftOrderTraversal(root.left, ans);
        leafTraversal(root, ans);
        rightOrderTraversal(root.right, ans);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(5);
        TreeNode leafNode2 = new TreeNode(6);
        TreeNode leafNode3 = new TreeNode(3);
        TreeNode leafNode4 = new TreeNode(7);
        TreeNode node1 = new TreeNode(4, leafNode1, leafNode2);
        TreeNode node2 = new TreeNode(2, leafNode3, node1);
        TreeNode root = new TreeNode(1, node2, leafNode4);
        System.out.println(new BoundaryTraversalOfTree().boundaryTraversal(root));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(H)