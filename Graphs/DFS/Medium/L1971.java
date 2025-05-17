package Graphs.DFS.Medium;

// 1976. Number of Ways to Arrive at Destination

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class NodePair{
    int node;
    long dist;

    public NodePair(int node, long dist) {
        this.node = node;
        this.dist = dist;
    }
}

public class L1971 {
    public int countPaths(int n, int[][] roads) {
        List<List<NodePair>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] r : roads){
            adjList.get(r[0]).add(new NodePair(r[1], r[2]));
            adjList.get(r[1]).add(new NodePair(r[0], r[2]));
        }
        long[] dist = new long[n];
        long[] ways = new long[n];
        for(int i=1;i<n;i++){
            dist[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<NodePair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        pq.add(new NodePair(0, 0));
        long mod = (int)(1e9+7);
        while(!pq.isEmpty()){
            NodePair np = pq.poll();
            int node = np.node;
            long dis = np.dist;
            for(NodePair adj : adjList.get(node)){
                int adjNode = adj.node;
                long adjDist = adj.dist;
                if(dis + adjDist < dist[adjNode]){
                    dist[adjNode] = dis + adjDist;
                    ways[adjNode] = ways[node];
                    pq.add(new NodePair(adjNode, dist[adjNode]));
                }else if(dis + adjDist == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode]+ ways[node])%mod;
                }
            }
        }
        return (int)(ways[n-1]% mod);
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {
                {0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}
        };
        System.out.println(new L1971().countPaths(n, roads));
    }
}

// Time Complexity - O(E * log V))
// Space Complexity - O(N)