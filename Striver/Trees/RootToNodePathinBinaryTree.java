package Striver.Trees;

// Root to Node Path in Binary Tree

import java.util.ArrayList;
import java.util.List;

public class RootToNodePathinBinaryTree {
    private void helper(TreeNode root, List<Integer> list, List<List<Integer>> res, int target) {
        if (root == null)
            return;
        if (root.val == target) {
            list.add(root.val);
            res.add(new ArrayList<>(list));
        }
        list.add(root.val);
        helper(root.left, list, res, target);
        helper(root.right, list, res, target);
        list.remove(list.size() - 1);
    }

    private List<List<Integer>> rootToNodePath(TreeNode root, int target) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(root, new ArrayList<>(), res, target);
        return res;
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(40);
        TreeNode leafNode2 = new TreeNode(60);
        TreeNode leafNode3 = new TreeNode(90);
        TreeNode leafNode4 = new TreeNode(100);
        TreeNode node1 = new TreeNode(20, leafNode1, leafNode2);
        TreeNode node2 = new TreeNode(30, leafNode3, leafNode4);
        TreeNode root = new TreeNode(10, node1, node2);
        System.out.println(new RootToNodePathinBinaryTree().rootToNodePath(root, 60));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(H)