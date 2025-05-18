package Striver.Graphs;

// G-41. Bellman Ford Algorith
//This helps to detect the negative cycles.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFordAlgo {
    private int[] bellman_ford(int n, ArrayList<ArrayList<Integer>> edges, int src) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i < n - 1; i++) {
            for (List<Integer> e : edges) {
                int u = e.get(0);
                int v = e.get(1);
                int wt = e.get(2);
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for (List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            int wt = e.get(2);
            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> edges = new ArrayList() {
            {
                add(new ArrayList<Integer>(Arrays.asList(3, 2, 6)));
                add(new ArrayList<Integer>(Arrays.asList(5, 3, 1)));
                add(new ArrayList<Integer>(Arrays.asList(0, 1, 5)));
                add(new ArrayList<Integer>(Arrays.asList(1, 5, -3)));
                add(new ArrayList<Integer>(Arrays.asList(1, 2, -2)));
                add(new ArrayList<Integer>(Arrays.asList(3, 4, -2)));
                add(new ArrayList<Integer>(Arrays.asList(2, 4, 3)));
            }
        };
        int V = 6;
        BellmanFordAlgo obj = new BellmanFordAlgo();
        int[] result = obj.bellman_ford(V, edges, 0);
        Arrays.stream(result).forEach(a -> System.out.print(a + " "));
    }
}

// Note : works for both Directed & Undirected grahs. You need to convert Undirected graph into directed one.

// Time Complexity: O(V*E), where V = no. of vertices and E = no. of Edges.
// Space Complexity: O(V) for the distance array which stores the minimized distances.