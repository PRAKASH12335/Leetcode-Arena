package Striver;

// Top View & Bottom View of the Binary Tree

import java.util.*;

class Pair {
    int hc;
    TreeNode node;

    Pair(int hc, TreeNode node) {
        this.hc = hc;
        this.node = node;
    }
}

public class TopAndBottomViewOfBinaryTree {
    List<Integer> topView(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (!map.containsKey(p.hc)) {
                map.put(p.hc, p.node.val);
            }
            if (p.node.left != null) {
                q.add(new Pair(p.hc - 1, p.node.left));
            }
            if (p.node.right != null) {
                q.add(new Pair(p.hc + 1, p.node.right));
            }
        }
        return new ArrayList<>(map.values());
    }

    List<Integer> bottomView(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, root));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            map.put(p.hc, p.node.val);
            if (p.node.left != null) {
                q.add(new Pair(p.hc - 1, p.node.left));
            }
            if (p.node.right != null) {
                q.add(new Pair(p.hc + 1, p.node.right));
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(40);
        TreeNode leafNode2 = new TreeNode(60);
        TreeNode leafNode3 = new TreeNode(90);
        TreeNode leafNode4 = new TreeNode(100);
        TreeNode node1 = new TreeNode(20, leafNode1, leafNode2);
        TreeNode node2 = new TreeNode(30, leafNode3, leafNode4);
        TreeNode root = new TreeNode(10, node1, node2);
        TopAndBottomViewOfBinaryTree tb = new TopAndBottomViewOfBinaryTree();
        System.out.println(tb.topView(root));
        System.out.println(tb.bottomView(root));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)