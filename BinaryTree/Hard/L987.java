package BinaryTree.Hard;

// 987. Vertical Order Traversal of a Binary Tree

import java.util.*;

class Point {
    int x;
    int y;
    int val;

    Point(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

public class L987 {
    private void listUtil(List<Point> list, int x, int y, TreeNode root) {
        if (root == null)
            return;
        list.add(new Point(x, y, root.val));
        listUtil(list, x - 1, y - 1, root.left);
        listUtil(list, x + 1, y - 1, root.right);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Point> list = new ArrayList<>();
        if (root == null)
            return new ArrayList<>();
        listUtil(list, 0, 0, root);
        Collections.sort(list, (a, b) -> a.x == b.x ? b.y == a.y ? a.val - b.val : b.y - a.y : a.x - b.x);
        Map<Integer, List<Integer>> tmap = new TreeMap<>();
        for (Point p : list) {
            List<Integer> line = tmap.getOrDefault(p.x, new ArrayList<>());
            line.add(p.val);
            tmap.put(p.x, line);
        }
        return new ArrayList<>(tmap.values());
    }

    public static void main(String[] args) {
        TreeNode leafNode1 = new TreeNode(9);
        TreeNode leafNode2 = new TreeNode(15);
        TreeNode leafNode3 = new TreeNode(7);
        TreeNode node1 = new TreeNode(20, leafNode2, leafNode3);
        TreeNode root = new TreeNode(3, leafNode1, node1);
        System.out.println(new L987().verticalTraversal(root));
    }
}

// Time Complexity - O(N * log N)
// Space Complexity - O(N)