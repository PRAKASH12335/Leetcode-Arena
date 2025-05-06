package BinaryTree.Medium;

// 863. All Nodes Distance K in Binary Tree

import java.util.*;

public class L863 {
    private void mapParents(Map<TreeNode, TreeNode> parents, TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    parents.put(node.left, node);
                    q.add(node.left);
                }
                if (node.right != null) {
                    parents.put(node.right, node);
                    q.add(node.right);
                }
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return null;
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        mapParents(parents, root);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> vis = new HashSet<>();
        q.add(target);
        vis.add(target);
        int dis = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (k == dis) break;
            dis++;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null && !vis.contains(node.left)) {
                    q.add(node.left);
                    vis.add(node.left);
                }
                if (node.right != null && !vis.contains(node.right)) {
                    q.add(node.right);
                    vis.add(node.right);
                }
                if (parents.get(node) != null && !vis.contains(parents.get(node))) {
                    q.add(parents.get(node));
                    vis.add(parents.get(node));
                }
            }
        }
        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(7);
        TreeNode leafNode2 = new TreeNode(4);
        TreeNode node1 = new TreeNode(2, leafNode1, leafNode2);
        TreeNode leafNode3 = new TreeNode(0);
        TreeNode leafNode4 = new TreeNode(8);
        TreeNode leafNode5 = new TreeNode(6);
        TreeNode node2 = new TreeNode(1, leafNode3, leafNode4);
        TreeNode node3 = new TreeNode(5, leafNode5, node1);
        TreeNode root = new TreeNode(3, node3, node2);
        System.out.println(new L863().distanceK(root, node3, 2));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)