package BinaryTree.Easy;

// 700. Search in a Binary Search Tree

public class L700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null)
            return null;
        while (root != null) {
            if (root.val == val)
                return root;
            else if (root.val > val)
                root = root.left;
            else
                root = root.right;
        }
        return null;
    }

    private void printTree(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(1);
        TreeNode leafNode2 = new TreeNode(3);
        TreeNode leafNode3 = new TreeNode(7);
        TreeNode node1 = new TreeNode(2, leafNode1, leafNode2);
        TreeNode root = new TreeNode(4, node1, leafNode3);
        L700 obj = new L700();
        TreeNode ans = obj.searchBST(root, 2);
        obj.printTree(ans);
    }
}

// Time Complexity - O(log N)
// Space Complexity - O(1)