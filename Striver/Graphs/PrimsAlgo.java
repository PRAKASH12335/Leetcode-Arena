package Striver.Graphs;

// G-45. Prim's Algorithm - Minimum Spanning Tree

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Edge {
    int node;
    int weight;

    public Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}

public class PrimsAlgo {
    public int minimumSpanningTree(int n, int[][] edges) {
        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adjList.get(e[0]).add(new Edge(e[1], e[2]));
            adjList.get(e[1]).add(new Edge(e[0], e[2]));
        }
        boolean[] vis = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Edge(0, 0));
        int sum = 0;
        while (!pq.isEmpty()) {
            Edge en = pq.poll();
            int node = en.node;
            int w = en.weight;
            if (vis[node] == true)
                continue;
            vis[node] = true;
            sum += w;
            for (Edge adjNode : adjList.get(node)) {
                int newNode = adjNode.node;
                int newWeight = adjNode.weight;
                if (vis[newNode] == false)
                    pq.add(new Edge(newNode, newWeight));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
        PrimsAlgo obj = new PrimsAlgo();
        System.out.println(obj.minimumSpanningTree(V, edges));
    }
}

// Time Complexity: O(E*logE) + O(E*logE)~ O(E*logE), where E = no. of given edges.
// Space Complexity: O(E) + O(V), where E = no. of edges and V = no. of vertices.