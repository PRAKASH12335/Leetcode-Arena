package Graphs.DFS.Medium;

// 934. Shortest Bridge

import java.util.LinkedList;
import java.util.Queue;

public class L934 {
    public boolean isSafe(int i, int j, int n) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }

    public void dfs(int i, int j, int n, int[][] grid, Queue<int[]> q) {
        if (!isSafe(i, j, n) || grid[i][j] != 1)
            return;
        q.add(new int[]{i, j, 0});
        grid[i][j] = 2;
        dfs(i + 1, j, n, grid, q);
        dfs(i - 1, j, n, grid, q);
        dfs(i, j + 1, n, grid, q);
        dfs(i, j - 1, n, grid, q);
    }

    public int bfs(int[][] grid, Queue<int[]> q) {
        int[] dirX = {0, 0, 1, -1};
        int[] dirY = {1, -1, 0, 0};
        int n = grid.length;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int steps = curr[2];
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dirX[i];
                int ny = curr[1] + dirY[i];
                if (isSafe(nx, ny, n)) {
                    if (grid[nx][ny] == 1)
                        return steps;
                    else if (grid[nx][ny] == 0) {
                        grid[nx][ny] = -1;
                        q.add(new int[]{nx, ny, steps + 1});
                    }
                }
            }
        }
        return 0;
    }

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, n, grid, q);
                    return bfs(grid, q);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };
        System.out.println(new L934().shortestBridge(grid));
    }
}

// Time Complexity - O(N * N)
// Space Complexity - O(N * N)