package Striver.Graphs;

// Shortest Path in Directed Acyclic Graph

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Pair {
    int node;
    int weight;

    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class ShortestPathinDAG {
    private void dfs(int node, Stack<Integer> st, boolean[] vis, List<List<Pair>> adjList) {
        vis[node] = true;
        for (Pair e : adjList.get(node)) {
            int adjNode = e.node;
            if (vis[adjNode] == false) {
                dfs(adjNode, st, vis, adjList);
            }
        }
        st.push(node);
    }

    private int[] shortestPath(int n, int m, int[][] edge) {
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] e : edge) {
            adjList.get(e[0]).add(new Pair(e[1], e[2]));
        }
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                dfs(i, st, vis, adjList);
            }
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[6] = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            for (Pair p : adjList.get(node)) {
                int temp = p.node;
                int weight = p.weight;
                if (dist[node] + weight < dist[temp]) {
                    dist[temp] = dist[node] + weight;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                dist[i] = -1;
        }
        return dist;
    }

    public static void main(String[] args) {
        int n = 6, m = 7;
        int[][] edge = {{0, 1, 2}, {0, 4, 1}, {4, 5, 4}, {4, 2, 2}, {1, 2, 3}, {2, 3, 6}, {5, 3, 1}};
        ShortestPathinDAG obj = new ShortestPathinDAG();
        int dist[] = obj.shortestPath(n, m, edge);
        for (int i = 0; i < n; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
}

// Time Complexity - O(M + N)
// Space Complexity - O(M + N)