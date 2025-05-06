package BinaryTree.Medium;

// 236. Lowest Common Ancestor of a Binary Tree

public class L236 {
    private boolean find(TreeNode root, TreeNode p) {
        if (root == null)
            return false;
        if (root.val == p.val)
            return true;
        return find(root.left, p) || find(root.right, p);
    }

    private TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root.val == p.val || root.val == q.val)
            return root;
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        if (left != null && right != null)
            return root;
        return left != null ? left : right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (!(find(root, p) && find(root, p)))
            return null;
        return LCA(root, p, q);
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(40);
        TreeNode leafNode2 = new TreeNode(60);
        TreeNode leafNode3 = new TreeNode(90);
        TreeNode leafNode4 = new TreeNode(100);
        TreeNode node1 = new TreeNode(20, leafNode1, leafNode2);
        TreeNode node2 = new TreeNode(30, leafNode3, leafNode4);
        TreeNode root = new TreeNode(10, node1, node2);
        L236 obj = new L236();
        TreeNode node = obj.lowestCommonAncestor(root, leafNode1, leafNode2);
        System.out.println(node.val);

    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)