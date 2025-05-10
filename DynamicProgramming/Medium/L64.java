package DynamicProgramming.Medium;

// 64. Minimum Path Sum

public class L64 {
    // Recursion
    private int helper(int[][] grid, int m, int n) {
        if (m == 0 && n == 0) return grid[m][n];
        if (m < 0 || n < 0) return Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int up = Integer.MAX_VALUE;
        if (n - 1 >= 0)
            left = grid[m][n] + helper(grid, m, n - 1);
        if (m - 1 >= 0)
            up = grid[m][n] + helper(grid, m - 1, n);
        return Math.min(left, up);
    }

    public int minPathSumRec(int[][] grid) {
        return helper(grid, grid.length - 1, grid[0].length - 1);
    }
    // Time Complexity - O(2^M*N)
    // Space Complexity - O(M*N)

    // DP
    public static int minPathSumDP(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++)
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        for (int i = 1; i < n; i++)
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }
    // Time Complexity - O(M*N)
    // Space Complexity - O(M*N)

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        L64 obj = new L64();
        System.out.println(obj.minPathSumRec(grid));
        System.out.println(obj.minPathSumDP(grid));
    }
}