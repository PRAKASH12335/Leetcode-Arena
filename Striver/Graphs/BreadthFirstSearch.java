package Striver.Graphs;

// G-5. Breadth-First Search

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    private List<Integer> bfs(int v, List<List<Integer>> adjList, int n) {
        boolean[] vis = new boolean[n];
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        vis[v] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for (int it : adjList.get(node)) {
                if (vis[it] == false) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        int n = 7;
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(1);
        adjList.get(0).add(2);
        adjList.get(1).add(0);
        adjList.get(2).add(0);
        adjList.get(2).add(3);
        adjList.get(3).add(2);
        adjList.get(1).add(4);
        adjList.get(4).add(1);
        adjList.get(2).add(5);
        adjList.get(5).add(2);
        adjList.get(4).add(6);
        adjList.get(6).add(4);
        adjList.get(5).add(6);
        adjList.get(6).add(5);
        BreadthFirstSearch obj = new BreadthFirstSearch();
        System.out.println(obj.bfs(0, adjList, n));
    }
}

// Time Complexity - O(V + 2E)
// Space Complexity - O(3N) ~ O(N)