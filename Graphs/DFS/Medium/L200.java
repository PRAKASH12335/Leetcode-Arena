package Graphs.DFS.Medium;

// 200. Number of Islands

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class L200 {
    // BFS
    private void bfs(int row, int col, int m, int n, char[][] grid, boolean[][] vis) {
        vis[row][col] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.first;
            int c = p.second;
            int[] dirX = {0, 0, -1, 1};
            int[] dirY = {1, -1, 0, 0};
            for (int i = 0; i < 4; i++) {
                int nr = r + dirX[i];
                int nc = c + dirY[i];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && vis[nr][nc] == false && grid[nr][nc] == '1') {
                    q.add(new Pair(nr, nc));
                    vis[nr][nc] = true;
                }
            }
        }
    }

    public int numIslandsBFS(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int cnt = 0;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (vis[i][j] == false && grid[i][j] == '1') {
                    cnt++;
                    bfs(i, j, m, n, grid, vis);
                }
            }
        }
        return cnt;
    }

    // DFS
    private int dfs(int i, int j, int m, int n, char[][] grid, boolean[][] vis) {
        if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j] || grid[i][j] == '0')
            return 0;
        vis[i][j] = true;
        dfs(i + 1, j, m, n, grid, vis);
        dfs(i - 1, j, m, n, grid, vis);
        dfs(i, j + 1, m, n, grid, vis);
        dfs(i, j - 1, m, n, grid, vis);
        return 1;
    }

    public int numIslandsDFS(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int cnt = 0;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    cnt += dfs(i, j, m, n, grid, vis);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        L200 obj = new L200();
        System.out.println(obj.numIslandsDFS(grid));
        System.out.println(obj.numIslandsBFS(grid));
    }
}

// Time Complexity - O(N*N)
// Space Complexity - O(N*N)