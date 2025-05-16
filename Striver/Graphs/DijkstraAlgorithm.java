package Striver.Graphs;

// G-32. Dijkstra's Algorithm - Using Priority Queue

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class NodePair {
    int node;
    int dist;

    public NodePair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

public class DijkstraAlgorithm {
    private int[] dijkstra(int V, int[][] edges, int src) {
        List<List<NodePair>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adjList.get(e[0]).add(new NodePair(e[1], e[2]));
            adjList.get(e[1]).add(new NodePair(e[0], e[2]));
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<NodePair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        pq.add(new NodePair(src, 0));

        while (!pq.isEmpty()) {
            NodePair nd = pq.poll();
            int curr = nd.node;
            int dis = nd.dist;
            for (NodePair np : adjList.get(curr)) {
                int newNode = np.node;
                int newDist = np.dist;
                if (newDist + dis < dist[newNode]) {
                    dist[newNode] = newDist + dis;
                    pq.add(new NodePair(newNode, dist[newNode]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        DijkstraAlgorithm obj = new DijkstraAlgorithm();
        int V = 6, src = 1;
        int[][] edges = {{0, 1, 4}, {0, 2, 4}, {1, 2, 2}, {2, 3, 3}, {2, 4, 1}, {2, 5, 6}, {3, 5, 2}, {4, 5, 3}};
        int[] res = obj.dijkstra(V, edges, src);
        Arrays.stream(res).forEach(a -> System.out.print(a + " "));
    }
}

// Time Complexity - O( E log(V) ), Where E = Number of edges and V = Number of Nodes.
// Space Complexity - O( |E| + |V| ), Where E = Number of edges and V = Number of Nodes.