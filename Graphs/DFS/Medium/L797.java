package Graphs.DFS.Medium;

// 797. All Paths From Source to Target

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int g : graph[i]) {
                adjList.get(i).add(g);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(Arrays.asList(0));
        while (!q.isEmpty()) {
            List<Integer> path = q.poll();
            int lastVertex = path.get(path.size() - 1);
            if (lastVertex == n - 1) {
                ans.add(path);
            } else {
                for (int it : adjList.get(lastVertex)) {
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(it);
                    q.add(newPath);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        System.out.println(new L797().allPathsSourceTarget(graph));
    }
}

// Time Complexity: O(N + E)
//Space complexity: O(N)