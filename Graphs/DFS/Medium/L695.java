package Graphs.DFS.Medium;

// 695. Max Area of Island

public class L695 {
    private int dfs(int i, int j, int m, int n, int[][] grid, boolean[][] vis) {
        if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j] == true || grid[i][j] == 0)
            return 0;
        vis[i][j] = true;
        int count = dfs(i + 1, j, m, n, grid, vis) +
                dfs(i - 1, j, m, n, grid, vis) +
                dfs(i, j + 1, m, n, grid, vis) +
                dfs(i, j - 1, m, n, grid, vis);
        return count + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && vis[i][j] == false) {
                    ans = Math.max(ans, dfs(i, j, m, n, grid, vis));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(new L695().maxAreaOfIsland(grid));
    }
}

// Time Complexity - O(M * N)
// Space Complexity - O(M * N)