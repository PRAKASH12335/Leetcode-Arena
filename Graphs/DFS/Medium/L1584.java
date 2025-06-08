package Graphs.DFS.Medium;

// 1584. Min Cost to Connect All Points

import java.util.PriorityQueue;

public class L1584 {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] vis = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{0, 0});
        int mstCost = 0;
        int edgesUsed = 0;

        while (!pq.isEmpty() && edgesUsed < n) {
            int[] curr = pq.poll();
            int u = curr[0], weight = curr[1];

            if (vis[u]) continue;
            vis[u] = true;
            mstCost += weight;
            edgesUsed++;

            for (int v = 0; v < n; v++) {
                if (!vis[v]) {
                    int dist = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                    pq.add(new int[]{v, dist});
                }
            }
        }
        return mstCost;
    }

    public static void main(String[] args) {
        int[][] points = {
                {0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}
        };
        System.out.println(new L1584().minCostConnectPoints(points));
    }
}

// Time Complexity - O(N*N * log(N))
// Space Complexity - O(N*N)