package BinaryTree.Medium;

// 701. Insert into a Binary Search Tree

public class L701 {
    private void printTree(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return new TreeNode(val);
        TreeNode curr = root;

        // Recusion
//        if(curr.val > val)
//            curr.left = insertIntoBST(root.left, val);
//        else
//            curr.right = insertIntoBST(root.right, val);

        // iterative
        while (true) {
            if (curr.val <= val) {
                if (curr.right != null)
                    curr = curr.right;
                else {
                    curr.right = new TreeNode(val);
                    break;
                }
            } else {
                if (curr.left != null)
                    curr = curr.left;
                else {
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(1);
        TreeNode leafNode2 = new TreeNode(3);
        TreeNode leafNode3 = new TreeNode(7);
        TreeNode node1 = new TreeNode(2, leafNode1, leafNode2);
        TreeNode root = new TreeNode(4, node1, leafNode3);
        L701 obj = new L701();
        TreeNode ans = obj.insertIntoBST(root, 5);
        obj.printTree(ans);
    }
}

// Time Complexity - O(log N)
// Space Complexity - O(1)