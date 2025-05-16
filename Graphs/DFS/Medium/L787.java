package Graphs.DFS.Medium;

//  787. Cheapest Flights Within K Stops

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Arrays;

class StopCost {
    int node;
    int cost;

    public StopCost(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}

class Flight {
    int stop;
    int node;
    int cost;

    public Flight(int stop, int node, int cost) {
        this.stop = stop;
        this.node = node;
        this.cost = cost;
    }
}

public class L787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<StopCost>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] f : flights) {
            adjList.get(f[0]).add(new StopCost(f[1], f[2]));
        }

        Queue<Flight> q = new LinkedList<>();
        q.add(new Flight(0, src, 0));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!q.isEmpty()) {
            Flight f = q.poll();
            int stop = f.stop;
            int node = f.node;
            int cost = f.cost;
            for (StopCost newNode : adjList.get(node)) {
                int adjNode = newNode.node;
                int adjCost = newNode.cost;
                if (adjCost + cost < dist[adjNode] && stop <= k) {
                    dist[adjNode] = adjCost + cost;
                    q.add(new Flight(stop + 1, adjNode, dist[adjNode]));
                }
            }
        }
        if (dist[dst] == Integer.MAX_VALUE) return -1;
        return dist[dst];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0, dst = 3, k = 1;
        L787 obj = new L787();
        System.out.println(obj.findCheapestPrice(n, flights, src, dst, k));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(E + V)