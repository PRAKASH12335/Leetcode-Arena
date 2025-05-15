package Graphs.DFS.Medium;

// 1020. Number of Enclaves

public class L1020 {
    private void dfs(int i, int j, int m, int n, int[][] grid, boolean[][] vis) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || vis[i][j] == true)
            return;
        vis[i][j] = true;
        dfs(i + 1, j, m, n, grid, vis);
        dfs(i - 1, j, m, n, grid, vis);
        dfs(i, j + 1, m, n, grid, vis);
        dfs(i, j - 1, m, n, grid, vis);
    }

    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || i == m - 1 || j == 0 || j == n - 1) && grid[i][j] == 1 && vis[i][j] == false) {
                    dfs(i, j, m, n, grid, vis);
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && vis[i][j] == false)
                    cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
        };
        System.out.println(new L1020().numEnclaves(grid));
    }
}

// Time Complexity - O(M*N)
// Space Complexity - O(M*N)