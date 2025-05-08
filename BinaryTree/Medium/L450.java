package BinaryTree.Medium;

// 450. Delete Node in a BST

public class L450 {
    private void printTree(TreeNode root) {
        if (root == null) return;
        printTree(root.left);
        System.out.println(root.val + " ");
        printTree(root.right);
    }

    private int predessor(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    private int successor(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.left != null) {
                root.val = predessor(root.left);
                root.left = deleteNode(root.left, root.val);
            } else if (root.right != null) {
                root.val = successor(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(2);
        TreeNode leafNode2 = new TreeNode(4);
        TreeNode leafNode3 = new TreeNode(7);
        TreeNode node1 = new TreeNode(3, leafNode1, leafNode2);
        TreeNode node2 = new TreeNode(6, null, leafNode3);
        TreeNode root = new TreeNode(5, node1, node2);
        L450 obj = new L450();
        TreeNode ans = obj.deleteNode(root, 3);
        obj.printTree(ans);
    }
}

// Time Complexity - O(H)
// Space Complexity - O(N)