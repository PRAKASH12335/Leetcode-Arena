package BinaryTree.Medium;

// 2385. Amount of Time for Binary Tree to Be Infected

import java.util.*;

public class L2385 {
    private TreeNode mapParents(Map<TreeNode, TreeNode> parents, TreeNode root, int start) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode startNode = null;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (start == node.val) {
                    startNode = node;
                }
                if (node.left != null) {
                    q.add(node.left);
                    parents.put(node.left, node);
                }
                if (node.right != null) {
                    q.add(node.right);
                    parents.put(node.right, node);
                }
            }
        }
        return startNode;
    }

    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        TreeNode startNode = mapParents(parents, root, start);
        Set<TreeNode> vis = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(startNode);
        vis.add(startNode);
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean enqueued = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null && !vis.contains(node.left)) {
                    q.add(node.left);
                    vis.add(node.left);
                    enqueued = true;
                }
                if (node.right != null && !vis.contains(node.right)) {
                    q.add(node.right);
                    vis.add(node.right);
                    enqueued = true;
                }
                if (parents.get(node) != null && !vis.contains(parents.get(node))) {
                    q.add(parents.get(node));
                    vis.add(parents.get(node));
                    enqueued = true;
                }
            }
            if (enqueued)
                time++;
        }
        return time;
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(9);
        TreeNode leafNode2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(4, leafNode1, leafNode2);
        TreeNode leafNode3 = new TreeNode(10);
        TreeNode leafNode4 = new TreeNode(6);
        TreeNode node2 = new TreeNode(3, leafNode3, leafNode4);
        TreeNode node3 = new TreeNode(5, null, node1);
        TreeNode root = new TreeNode(1, node3, node2);
        System.out.println(new L2385().amountOfTime(root, 3));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)