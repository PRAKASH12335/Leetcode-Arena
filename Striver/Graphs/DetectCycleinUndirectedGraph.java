package Striver.Graphs;

// G-11. Detect a Cycle in an Undirected Graph

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int node;
    int parent;

    public Node(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

public class DetectCycleinUndirectedGraph {
    // BFS
    private boolean bfs(int node, List<List<Integer>> adjList, boolean[] vis) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(node, -1));
        vis[node] = true;

        while (!q.isEmpty()) {
            Node temp = q.poll();
            int curr = temp.node;
            int par = temp.parent;
            for (int it : adjList.get(curr)) {
                if (vis[it] == false) {
                    vis[it] = true;
                    q.add(new Node(it, curr));
                } else if (par != it)
                    return true;
            }
        }
        return false;
    }

    private boolean detectCycleBFS(List<List<Integer>> adjList, int n) {
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                if (bfs(i, adjList, vis)) return true;
            }
        }
        return false;
    }

    // DFS
    private boolean dfs(int node, int par, List<List<Integer>> adjList, boolean[] vis) {
        vis[node] = true;
        for (int it : adjList.get(node)) {
            if (vis[it] == false) {
                if (dfs(it, node, adjList, vis))
                    return true;
                else if (par != it)
                    return true;
            }
        }
        return false;
    }

    private boolean detectCycleDFS(List<List<Integer>> adjList, int n) {
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                if (dfs(i, -1, adjList, vis)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n = 7;
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(1);
        adjList.get(0).add(2);
        adjList.get(1).add(0);
        adjList.get(2).add(0);
        adjList.get(2).add(3);
        adjList.get(3).add(2);
        adjList.get(1).add(4);
        adjList.get(4).add(1);
        adjList.get(2).add(5);
        adjList.get(5).add(2);
        adjList.get(4).add(6);
        adjList.get(6).add(4);
        adjList.get(5).add(6);
        adjList.get(6).add(5);
        DetectCycleinUndirectedGraph obj = new DetectCycleinUndirectedGraph();
        System.out.println(obj.detectCycleBFS(adjList, n));
        System.out.println(obj.detectCycleDFS(adjList, n));
    }
}

// Time Complexity - O(V + 2E)
// Space Complexity - O(3N) ~ O(N)