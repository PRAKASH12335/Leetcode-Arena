package Graphs.DFS.Medium;

// 802. Find Eventual Safe States

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Collections;

public class L802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> revAdjList = new ArrayList<>();
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            revAdjList.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int it : graph[i]) {
                revAdjList.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (int it : revAdjList.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.add(it);
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}};
        System.out.println(new L802().eventualSafeNodes(graph));
    }
}

// Time Complexity: O(N+E)
//Space complexity: O(N)+O(N)