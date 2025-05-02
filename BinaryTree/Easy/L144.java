package BinaryTree.Easy;

// 144. Binary Tree Preorder Traversal

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode temp = st.pop();
            ans.add(temp.val);
            if (temp.right != null)
                st.push(temp.right);
            if (temp.left != null)
                st.push(temp.left);
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
        System.out.println(new L144().preorderTraversal(root));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)