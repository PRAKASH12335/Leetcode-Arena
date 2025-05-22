package Striver.Graphs;

// G-54. Strongly Connected Components - Kosaraju's Algorithm

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StronglyConnectedComponents {
    private void dfs(int node, boolean[] vis, Stack<Integer> st, List<List<Integer>> adj) {
        vis[node] = true;
        for (int it : adj.get(node)) {
            if (vis[it] == false) {
                dfs(it, vis, st, adj);
            }
        }
        st.push(node);
    }

    private void dfs3(int node, boolean[] vis, List<List<Integer>> adj) {
        vis[node] = true;
        for (int it : adj.get(node)) {
            if (vis[it] == false) {
                dfs3(it, vis, adj);
            }
        }
    }

    public int kosaraju(int n, List<List<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                dfs(i, vis, st, adj);
            }
        }

        List<List<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjT.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            vis[i] = false;
            for (Integer it : adj.get(i)) {
                adjT.get(it).add(i);
            }
        }

        int scc = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            if (vis[node] == false) {
                scc++;
                dfs3(node, vis, adjT);
            }
        }
        return scc;
    }

    public static void main(String[] args) {
        int n = 8;
        int[][] edges = {
                {0, 1}, {1, 2}, {2, 0},
                {2, 3}, {3, 4},
                {4, 5}, {5, 6}, {6, 4}, {6, 7}, {4, 7}
        };
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }
        StronglyConnectedComponents obj = new StronglyConnectedComponents();
        int ans = obj.kosaraju(8, adj);
        System.out.println("The number of strongly connected components is: " + ans);
    }
}

// Time Complexity - O(V+E) + O(V+E) + O(V+E) ~ O(V+E)
// Space Complexity - O(V)+O(V)+O(V+E)