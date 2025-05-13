package Striver.Graphs;

// G-6. Depth First Search

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    private void dfsHelper(int node, List<Integer> ans, boolean[] vis, List<List<Integer>> adjList) {
        ans.add(node);
        vis[node] = true;
        for (int it : adjList.get(node)) {
            if (vis[it] == false) {
                dfsHelper(it, ans, vis, adjList);
            }
        }
    }

    private List<Integer> dfs(List<List<Integer>> adjList, int n) {
        List<Integer> ans = new ArrayList<>();
        boolean[] vis = new boolean[n];
        dfsHelper(0, ans, vis, adjList);
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
        DepthFirstSearch obj = new DepthFirstSearch();
        System.out.println(obj.dfs(adjList, n));
    }
}

// Time Complexity - O(V + 2E)
// Space Complexity - O(3N) ~ O(N)