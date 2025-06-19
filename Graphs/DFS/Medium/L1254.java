package Graphs.DFS.Medium;

// 1254. Number of Closed Islands

public class L1254 {
    private boolean dfs(int i, int j, int m, int n, int[][] grid) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return false;
        if (grid[i][j] == 1)
            return true;
        grid[i][j] = 1;
        boolean left_closed = dfs(i - 1, j, m, n, grid);
        boolean up_closed = dfs(i, j - 1, m, n, grid);
        boolean right_closed = dfs(i + 1, j, m, n, grid);
        boolean down_closed = dfs(i, j + 1, m, n, grid);
        return left_closed && up_closed && right_closed && down_closed;
    }

    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && dfs(i, j, m, n, grid)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };
        System.out.println(new L1254().closedIsland(grid));
    }
}

// Time Complexity: O(M * N)
// Space Complexity: O(M * N)