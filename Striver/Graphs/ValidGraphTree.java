package Striver.Graphs;

// Graph Valid Tree

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ValidGraphTree {
    private boolean bfs(int node, boolean[] vis, List<List<Integer>> adjList) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(node, -1));
        vis[node] = true;

        while (!q.isEmpty()) {
            Node temp = q.poll();
            int nd = temp.node;
            int par = temp.parent;
            for (int it : adjList.get(nd)) {
                if (vis[it] == false) {
                    q.add(new Node(it, nd));
                    vis[it] = true;
                } else if (it != par)
                    return true;
            }
        }
        return false;
    }

    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[n];
        if (bfs(0, vis, adjList)) return false;
        for (int i = 0; i < n; i++) {
            if (vis[i] == false)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        System.out.println(new ValidGraphTree().validTree(n, edges));
    }
}

// Time Complexity - O(V + 2E)
// Space Complexity - O(N)