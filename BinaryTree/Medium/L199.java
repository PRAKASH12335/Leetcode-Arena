package BinaryTree.Medium;

// 199. Binary Tree Right Side View

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L199 {
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == 0)
                    ans.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return ans;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == 0)
                    ans.add(node.val);
                if (node.right != null) {
                    q.add(node.right);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(40);
        TreeNode leafNode2 = new TreeNode(60);
        TreeNode leafNode3 = new TreeNode(90);
        TreeNode leafNode4 = new TreeNode(100);
        TreeNode node1 = new TreeNode(20, leafNode1, leafNode2);
        TreeNode node2 = new TreeNode(30, leafNode3, leafNode4);
        TreeNode root = new TreeNode(10, node1, node2);
        L199 obj = new L199();
        System.out.println(obj.rightSideView(root));
        System.out.println(obj.leftSideView(root));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)