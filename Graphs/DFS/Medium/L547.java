package Graphs.DFS.Medium;

// 547. Number of Provinces

import java.util.ArrayList;
import java.util.List;

public class L547 {
    private void dfs(int node, boolean[] vis, List<List<Integer>> adjList) {
        vis[node] = true;
        for (int it : adjList.get(node)) {
            if (vis[it] == false) {
                dfs(it, vis, adjList);
            }
        }
    }

    private int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n = isConnected.length;
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }

        int cnt = 0;
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                cnt++;
                dfs(i, vis, adjList);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(new L547().findCircleNum(isConnected));
    }
}

// Time Complexity - O(N*N)+O(N+2E)
// Space Complexity - O(N)