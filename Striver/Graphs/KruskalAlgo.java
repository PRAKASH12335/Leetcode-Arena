package Striver.Graphs;

// G-47. Kruskal's Algorithm - Minimum Spanning Tree

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class EdgeNode implements Comparable<EdgeNode> {
    int src;
    int dest;
    int wt;

    public EdgeNode(int src, int dest, int wt) {
        this.src = src;
        this.dest = dest;
        this.wt = wt;
    }

    @Override
    public int compareTo(EdgeNode compareEdge) {
        return this.wt - compareEdge.wt;
    }
}

public class KruskalAlgo {
    public int spanningTree(int n, int[][] edges) {
        List<List<NodePair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adjList.get(e[0]).add(new NodePair(e[1], e[2]));
        }
        List<EdgeNode> edgeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (NodePair np : adjList.get(i)) {
                int node = i;
                int adjNode = np.node;
                int weight = np.dist;
                EdgeNode e = new EdgeNode(node, adjNode, weight);
                edgeList.add(e);
            }
        }

        DisjointSet ds = new DisjointSet(n);
        Collections.sort(edgeList);
        int mstWt = 0;
        for (int i = 0; i < edgeList.size(); i++) {
            int u = edgeList.get(i).src;
            int v = edgeList.get(i).dest;
            int wt = edgeList.get(i).wt;
            if (ds.findParent(u) != ds.findParent(v)) {
                mstWt += wt;
                ds.unionBySize(u, v);
            }
        }
        return mstWt;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
        KruskalAlgo obj = new KruskalAlgo();
        int mstWt = obj.spanningTree(n, edges);
        System.out.println(mstWt);
    }
}

// Time Complexity: O(4 alpha)
// Space Complexity: O(3N) ~ O(N)