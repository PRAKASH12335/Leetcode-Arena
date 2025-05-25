package Graphs.DFS.Medium;

// 886. Possible Bipartition

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L886 {
    private boolean dfs(int node, int col, int[] color, List<List<Integer>> adjList) {
        color[node] = col;
        for (int it : adjList.get(node)) {
            if (color[it] == -1) {
                if (dfs(it, 1 - col, color, adjList) == false) {
                    return false;
                }
            } else if (color[it] == color[node])
                return false;
        }
        return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] dl : dislikes) {
            adjList.get(dl[0] - 1).add(dl[1] - 1);
            adjList.get(dl[1] - 1).add(dl[0] - 1);
        }
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (dfs(i, 0, color, adjList) == false)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(new L886().possibleBipartition(n, dislikes));
    }
}

// Time Complexity - O(V + 2E)
// Space Complexity - O(3N) ~ O(N)