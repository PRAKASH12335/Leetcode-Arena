package Graphs.DFS.Medium;

// 1091. Shortest Path in Binary Matrix

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class DistNode {
    int dist;
    int x;
    int y;

    public DistNode(int dist, int x, int y) {
        this.dist = dist;
        this.x = x;
        this.y = y;
    }
}

public class L1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1)
            return -1;
        if (grid[0][0] == 0 && m == 1 && n == 1)
            return 1;
        Queue<DistNode> q = new LinkedList<>();
        q.add(new DistNode(1, 0, 0));
        int[][] dist = new int[m][n];
        Arrays.stream(dist).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));

        int[] dirX = {0, 0, 1, -1, -1, 1, -1, 1};
        int[] dirY = {1, -1, 0, 0, 1, -1, -1, 1};
        while (!q.isEmpty()) {
            DistNode dnode = q.poll();
            int x = dnode.x;
            int y = dnode.y;
            int dis = dnode.dist;
            for (int i = 0; i < 8; i++) {
                int r = dirX[i] + x;
                int c = dirY[i] + y;
                if (r >= 0 && c >= 0 && r < m && c < n && 1 + dis < dist[r][c] && grid[r][c] == 0) {
                    dist[r][c] = 1 + dis;
                    if (r == m - 1 && c == n - 1)
                        return dist[r][c];
                    q.add(new DistNode(dist[r][c], r, c));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(new L1091().shortestPathBinaryMatrix(grid));
    }
}

// Time Complexity - O(8*M*N)
// Space Complexity - O(M*N)