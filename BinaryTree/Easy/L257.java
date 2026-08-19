package BinaryTree.Easy;

// 257. Binary Tree Paths

import java.util.ArrayList;
import java.util.List;

public class L257 {
    private void helper(TreeNode root, List<String> ans, String temp) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            ans.add(temp + root.val);
        } else {
            temp = temp + root.val + "->";
            helper(root.left, ans, temp);
            helper(root.right, ans, temp);
        }
    }

    private List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(root, ans, "");
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        root.left = node1;
        root.right = node3;
        root.left.right = node2;
        System.out.println(new L257().binaryTreePaths(root));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(H)