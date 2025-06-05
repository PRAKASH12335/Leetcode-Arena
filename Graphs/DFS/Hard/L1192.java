package Graphs.DFS.Hard;

// 1192. Critical Connections in a Network

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1192 {
    int timer = 0;

    public void dfs(int node, int parent, List<List<Integer>> adjList, int[] low, int[] tin, boolean[] vis, List<List<Integer>> ans) {
        vis[node] = true;
        low[node] = tin[node] = timer;
        timer++;

        for (int it : adjList.get(node)) {
            if (it == parent) continue;
            if (vis[it] == false) {
                dfs(it, node, adjList, low, tin, vis, ans);
                low[node] = Math.min(low[node], low[it]);
                if (low[it] > tin[node]) {
                    ans.add(Arrays.asList(node, it));
                }
            }
            low[node] = Math.min(low[node], low[it]);
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (List<Integer> con : connections) {
            adjList.get(con.get(0)).add(con.get(1));
            adjList.get(con.get(1)).add(con.get(0));
        }
        boolean[] vis = new boolean[n];
        int[] low = new int[n];
        int[] tin = new int[n];
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, -1, adjList, low, tin, vis, ans);
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));
        connections.add(Arrays.asList(1, 3));
        int n = 4;
        System.out.println(new L1192().criticalConnections(n, connections));
    }
}

// Time Complexity - O(V+2E))
// Space Complexity - O(V+2E) + O(3V)