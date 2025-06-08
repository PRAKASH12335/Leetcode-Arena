package Graphs.DFS.Medium;

// 1568. Minimum Number of Days to Disconnect Island

public class L1568 {

    public void dfs(int i, int j, int m, int n, boolean[][] vis, int[][] grid) {
        if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j] || grid[i][j] == 0)
            return;
        vis[i][j] = true;
        dfs(i - 1, j, m, n, vis, grid);
        dfs(i + 1, j, m, n, vis, grid);
        dfs(i, j - 1, m, n, vis, grid);
        dfs(i, j + 1, m, n, vis, grid);
    }

    public int countIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int count = 0;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    dfs(i, j, m, n, vis, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public int minDays(int[][] grid) {
        if (countIslands(grid) != 1) return 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (countIslands(grid) != 1) return 1;
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}
        };
        System.out.println(new L1568().minDays(grid));
    }
}

// Time Complexity: O((M*N)^2)
// Space Complexity: O(M*N)