package Graphs.DFS.Medium;

// 785. Is Graph Bipartite?

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L745 {
    // BFS
    private boolean bfs(int node, int[] color, int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 0;

        while (!q.isEmpty()) {
            int nd = q.poll();
            for (int it : graph[nd]) {
                if (color[it] == -1) {
                    color[it] = 1 - color[nd];
                    q.add(it);
                } else if (color[it] == color[nd])
                    return false;
            }
        }
        return true;
    }

    public boolean isBipartiteBFS(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (bfs(i, color, graph) == false)
                    return false;
            }
        }
        return true;
    }

    // DFS
    private boolean dfs(int node, int col, int[] color, int[][] graph) {
        color[node] = col;
        for (int it : graph[node]) {
            if (color[it] == -1) {
                if (dfs(it, 1 - col, color, graph) == false)
                    return false;
                else if (color[it] == col)
                    return false;
            }
        }
        return true;
    }

    public boolean isBipartiteDFS(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (dfs(i, 0, color, graph) == false)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        L745 obj = new L745();
        System.out.println(obj.isBipartiteDFS(graph));
        System.out.println(obj.isBipartiteBFS(graph));
    }
}

// Time Complexity - O(V + 2E)
// Space Complexity - O(3N) ~ O(N)