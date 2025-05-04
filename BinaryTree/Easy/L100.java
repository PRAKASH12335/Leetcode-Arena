package BinaryTree.Easy;

// 100. Same Tree

public class L100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
            return true;
        return false;
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(2);
        TreeNode leafNode2 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1, leafNode1, leafNode2);
        TreeNode leafNode3 = new TreeNode(2);
        TreeNode leafNode4 = new TreeNode(3);
        TreeNode node2 = new TreeNode(1, leafNode3, leafNode4);
        System.out.println(new L100().isSameTree(node1, node2));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)