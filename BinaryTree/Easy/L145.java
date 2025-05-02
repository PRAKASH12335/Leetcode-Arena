package BinaryTree.Easy;

// 145. Binary Tree Postorder Traversal

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);
        while (!st1.isEmpty()) {
            TreeNode node = st1.pop();
            st2.push(node);
            if (node.left != null)
                st1.push(node.left);
            if (node.right != null)
                st1.push(node.right);
        }
        while (!st2.isEmpty()) {
            ans.add(st2.pop().val);
        }
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
        System.out.println(new L145().postorderTraversal(root));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)