package Striver.Graphs;

// G-35. Print shortest Path - Dijkstra's Algorithm

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PrintDijkstraAlgo {
    private List<Integer> dijkstraShortestPath(int n, int[][] edges, int src, int dest) {
        List<List<NodePair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adjList.get(e[0]).add(new NodePair(e[1], e[2]));
            adjList.get(e[1]).add(new NodePair(e[0], e[2]));
        }
        int[] dist = new int[n];
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }
        PriorityQueue<NodePair> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new NodePair(src, 0));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            NodePair nd = pq.poll();
            int node = nd.node;
            int dis = nd.dist;
            for (NodePair it : adjList.get(node)) {
                int adjNode = it.node;
                int adjDist = it.dist;
                if (dis + adjDist < dist[adjNode]) {
                    dist[adjNode] = dis + adjDist;
                    pq.add(new NodePair(adjNode, dist[adjNode]));
                    parent[adjNode] = node;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        if (dist[dest] == Integer.MAX_VALUE) {
            dist[dest] = -1;
            return path;
        }
        int node = dest;
        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }
        path.add(src);
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        PrintDijkstraAlgo obj = new PrintDijkstraAlgo();
        int V = 6, src = 1, dest = 5;
        int[][] edges = {{0, 1, 4}, {0, 2, 4}, {1, 2, 2}, {2, 3, 3}, {2, 4, 1}, {2, 5, 6}, {3, 5, 2}, {4, 5, 3}};
        List<Integer> res = obj.dijkstraShortestPath(V, edges, src, dest);
        System.out.println(res);
    }
}

// Time Complexity - O( E log(V) ), Where E = Number of edges and V = Number of Nodes.
// Space Complexity - O( |E| + |V| ), Where E = Number of edges and V = Number of Nodes.