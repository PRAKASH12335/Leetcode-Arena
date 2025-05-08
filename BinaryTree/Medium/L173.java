package BinaryTree.Medium;

// 173. Binary Search Tree Iterator

import java.util.Stack;

public class L173 {
    Stack<TreeNode> st;

    public L173(TreeNode root) {
        st = new Stack<>();
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode root = st.pop();
        int val = root.val;
        root = root.right;
        while (root != null) {
            st.push(root);
            root = root.left;
        }
        return val;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(3);
        TreeNode leafNode2 = new TreeNode(9);
        TreeNode leafNode3 = new TreeNode(20);
        TreeNode node2 = new TreeNode(15, leafNode2, leafNode3);
        TreeNode root = new TreeNode(7, leafNode1, node2);
        L173 bSTIterator = new L173(root);
        System.out.println(bSTIterator.next());    // return 3
        System.out.println(bSTIterator.next());    // return 7
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next());    // return 9
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next());    // return 15
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next());    // return 20
        System.out.println(bSTIterator.hasNext()); // return False
    }
}

// Time Complexity - O(H)
// Space Complexity - O(N)