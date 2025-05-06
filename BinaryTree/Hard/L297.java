package BinaryTree.Hard;

// 297. Serialize and Deserialize Binary Tree

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class L297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val).append(",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;
        String[] strs = data.split(",");
        Deque<String> dq = new LinkedList<>(Arrays.asList(strs));
        return deserializeHelper(dq);
    }

    private TreeNode deserializeHelper(Deque<String> dq) {
        if (dq.isEmpty())
            return null;
        String node = dq.poll();
        if (node.equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = deserializeHelper(dq);
        root.right = deserializeHelper(dq);
        return root;
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right))
            return true;
        return false;
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(2);
        TreeNode leafNode2 = new TreeNode(4);
        TreeNode leafNode3 = new TreeNode(5);
        TreeNode node1 = new TreeNode(3, leafNode2, leafNode3);
        TreeNode root = new TreeNode(1, leafNode1, node1);
        L297 obj = new L297();
        String s = obj.serialize(root);
        System.out.println(s);
        TreeNode node = obj.deserialize(s);
        System.out.println(obj.isSameTree(node, root));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)