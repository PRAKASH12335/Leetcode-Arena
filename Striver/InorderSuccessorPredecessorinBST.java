package Striver;

// Inorder Successor/Predecessor in BST

public class InorderSuccessorPredecessorinBST {

    private int findInorderSuccessorinBST(TreeNode root, int key) {
        if (root == null) return 0;
        TreeNode curr = root;
        int successor = 0;
        while (curr != null) {
            if (curr.val <= key) {
                curr = curr.right;
            } else {
                successor = curr.val;
                curr = curr.left;
            }
        }
        return successor;
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(1);
        TreeNode leafNode2 = new TreeNode(3);
        TreeNode leafNode3 = new TreeNode(6);
        TreeNode leafNode4 = new TreeNode(8);
        TreeNode leafNode5 = new TreeNode(10);
        TreeNode node1 = new TreeNode(4, leafNode2, null);
        TreeNode node2 = new TreeNode(2, leafNode1, node1);
        TreeNode node3 = new TreeNode(9, leafNode4, leafNode5);
        TreeNode node4 = new TreeNode(7, leafNode3, node3);
        TreeNode root = new TreeNode(5, node2, node4);
        System.out.println(new InorderSuccessorPredecessorinBST().findInorderSuccessorinBST(root, 8));
    }
}

// Time Complexity - O(H)
// Space Complexity - O(1)