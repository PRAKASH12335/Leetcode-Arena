package BinaryTree.Easy;

// 222. Count Complete Tree Nodes

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class L222 {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(4);
        TreeNode leafNode2 = new TreeNode(5);
        TreeNode leafNode3 = new TreeNode(6);
        TreeNode node1 = new TreeNode(2, leafNode1, leafNode2);
        TreeNode node2 = new TreeNode(3, leafNode3, null);
        TreeNode root = new TreeNode(1, node1, node2);
        System.out.println(new L222().countNodes(root));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(H) // H = Height of tree