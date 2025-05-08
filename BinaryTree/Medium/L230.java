package BinaryTree.Medium;

// 230. Kth Smallest Element in a BST

import java.util.Stack;

public class L230 {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return 0;
        Stack<TreeNode> st = new Stack<>();
        while (!st.isEmpty() || root != null) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            TreeNode node = st.pop();
            k--;
            if (k == 0)
                return node.val;
            root = node.right;
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(1);
        TreeNode leafNode2 = new TreeNode(4);
        TreeNode leafNode3 = new TreeNode(6);
        TreeNode node1 = new TreeNode(2, leafNode1, null);
        TreeNode node2 = new TreeNode(3, node1, leafNode2);
        TreeNode root = new TreeNode(5, node2, leafNode3);
        System.out.println(new L230().kthSmallest(root, 3));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)