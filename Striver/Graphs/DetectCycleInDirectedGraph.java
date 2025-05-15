package Striver.Graphs;

// G-23. Detect Cycle in Directed Graph

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInDirectedGraph {
    // BFS
    private boolean detectCycleBFS(int n, List<List<Integer>> adjList) {
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

        int cnt = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            cnt++;
            for (int it : adjList.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return cnt == n ? false : true;
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);
        DetectCycleInDirectedGraph obj = new DetectCycleInDirectedGraph();
        boolean ans = obj.detectCycleBFS(11, adj);
        if (ans)
            System.out.println("True");
        else
            System.out.println("False");
    }
}

// Time Complexity: O(N+E)
//Space complexity: O(N)