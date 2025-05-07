package BinaryTree.Medium;

// 235. Lowest Common Ancestor of a Binary Search Tree

public class L235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        // Recursion
//        if(root.val > p.val && root.val > q.val)
//            return lowestCommonAncestor(root.left, p, q);
//        else if (root.val < p.val && root.val < q.val)
//            return lowestCommonAncestor(root.right, p, q);
//        else
//            return root;

        // Iterative
        while (root != null) {
            if (root.val > p.val && root.val > q.val)
                root = root.left;
            else if (root.val < p.val && root.val < q.val)
                root = root.right;
            else
                return root;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(1);
        TreeNode leafNode2 = new TreeNode(3);
        TreeNode leafNode3 = new TreeNode(7);
        TreeNode node1 = new TreeNode(2, leafNode1, leafNode2);
        TreeNode root = new TreeNode(4, node1, leafNode3);
        System.out.println(new L235().lowestCommonAncestor(root, leafNode2, leafNode1).val);
    }
}

// Time Complexity - O(H)
// Space Complexity - O(1)