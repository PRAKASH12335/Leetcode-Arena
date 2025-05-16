package Graphs.DFS.Medium;

// 1631. Path With Minimum Effort

import java.util.Arrays;
import java.util.PriorityQueue;

public class L1631 {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] dist = new int[m][n];
        Arrays.stream(dist).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));
        PriorityQueue<DistNode> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.add(new DistNode(0, 0, 0));
        dist[0][0] = 0;
        int[] dirX = {0, 0, 1, -1};
        int[] dirY = {1, -1, 0, 0};

        while (!pq.isEmpty()) {
            DistNode dnode = pq.poll();
            int x = dnode.x;
            int y = dnode.y;
            int diff = dnode.dist;
            if (x == m - 1 && y == n - 1)
                return diff;
            for (int i = 0; i < 4; i++) {
                int r = x + dirX[i];
                int c = y + dirY[i];
                if (r >= 0 && c >= 0 && r < m && c < n) {
                    int newEffort = Math.max(diff, Math.abs(heights[r][c] - heights[x][y]));
                    if (newEffort < dist[r][c]) {
                        dist[r][c] = newEffort;
                        pq.add(new DistNode(newEffort, r, c));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        L1631 obj = new L1631();
        System.out.println(obj.minimumEffortPath(heights));
    }
}

// Time Complexity - O(4*N*M * log(N*M))
// Space Complexity - O(M*N)