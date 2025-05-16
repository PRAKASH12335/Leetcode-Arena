package Striver.Graphs;

// G-28. Shortest Path in Undirected Graph with Unit weights

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class ShortestPathinUndirectedGraph {

    private int[] shortestPath(int[][] edge, int n, int m, int src) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] e : edge) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int it : adjList.get(node)) {
                if (dist[node] + 1 < dist[it]) {
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int n = 9, m = 10;
        int[][] edge = {{0, 1}, {0, 3}, {3, 4}, {4, 5}, {5, 6}, {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}};
        ShortestPathinUndirectedGraph obj = new ShortestPathinUndirectedGraph();
        int res[] = obj.shortestPath(edge, n, m, 0);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}

// Time Complexity - O(M) + O(N + 2M) + O(N) ~ O(N+2M)
// Space Complexity - O(N) + O(N) + O(N) + O( N+2M) ~ O(N+M)