package BinaryTree.Medium;

// 114. Flatten Binary Tree to Linked List

import java.util.Stack;

public class L114 {
    private void printList(TreeNode root) {
        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            if (node.right != null)
                st.push(node.right);
            if (node.left != null)
                st.push(node.left);
            if (!st.isEmpty())
                node.right = st.peek();
            node.left = null;
        }
        printList(root);
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(3);
        TreeNode leafNode2 = new TreeNode(4);
        TreeNode leafNode3 = new TreeNode(6);
        TreeNode node1 = new TreeNode(2, leafNode1, leafNode2);
        TreeNode node2 = new TreeNode(5, null, leafNode3);
        TreeNode root = new TreeNode(1, node1, node2);
        new L114().flatten(root);
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)