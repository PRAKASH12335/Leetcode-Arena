package Striver.Graphs;

// G-21. Topological Sort

import java.util.*;

public class TopologicalSort {
    // DFS
    private void dfs(int node, Stack<Integer> st, boolean[] vis, List<List<Integer>> adjList) {
        vis[node] = true;
        for (int it : adjList.get(node)) {
            if (vis[it] == false) {
                dfs(it, st, vis, adjList);
            }
        }
        st.push(node);
    }

    private int[] topoSortDFS(int n, List<List<Integer>> adjList) {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                dfs(i, st, vis, adjList);
            }
        }
        int[] res = new int[n];
        int i = 0;
        while (!st.isEmpty()) {
            res[i++] = st.pop();
        }
        return res;
    }

    // BFS
    private int[] topoSortBFS(int n, List<List<Integer>> adjList) {
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int it : adjList.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int[] topo = new int[n];
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            topo[i++] = node;
            for (int it : adjList.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return topo;
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = 6;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        TopologicalSort ts = new TopologicalSort();
        int[] res1 = ts.topoSortDFS(n, adj);
        int[] res2 = ts.topoSortBFS(n, adj);

        System.out.println("Toposort of the given graph is:");
        for (int i = 0; i < res1.length; i++) {
            System.out.print(res1[i] + " ");
        }

        System.out.println("Toposort of the given graph is:");
        for (int i = 0; i < res2.length; i++) {
            System.out.print(res2[i] + " ");
        }
    }
}

// Time Complexity: O(N+E)
//Space complexity: O(N)+O(N)