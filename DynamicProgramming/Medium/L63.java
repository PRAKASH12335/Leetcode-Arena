package DynamicProgramming.Medium;

// 63. Unique Paths II

import java.util.Arrays;

public class L63 {
    // Recursion
    private int helper(int[][] obstacleGrid, int m, int n) {
        if (m >= 0 && n >= 0 && obstacleGrid[m][n] == 1) return 0;
        if (m == 0 && n == 0) return 1;
        if (m < 0 || n < 0) return 0;
        int left = helper(obstacleGrid, m, n - 1);
        int up = helper(obstacleGrid, m - 1, n);
        return left + up;
    }

    public int uniquePathsWithObstaclesRec(int[][] obstacleGrid) {
        return helper(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
    }
    // Time Complexity - O(2^M*N)
    // Space Complexity - O(M*N)

    // Memoization
    private int memoHelper(int[][] obstacleGrid, int m, int n, int[][] memo) {
        if (m >= 0 && n >= 0 && obstacleGrid[m][n] == 1) return 0;
        if (m == 0 && n == 0) return 1;
        if (m < 0 || n < 0) return 0;
        if (memo[m][n] != -1)
            return memo[m][n];
        int left = memoHelper(obstacleGrid, m, n - 1, memo);
        int up = memoHelper(obstacleGrid, m - 1, n, memo);
        return memo[m][n] = left + up;
    }

    public int uniquePathsWithObstaclesMemo(int[][] obstacleGrid) {
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));
        return memoHelper(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1, memo);
    }
    // Time Complexity - O(M*N)
    // Space Complexity - O(M*N)

    // DP
    public int uniquePathsWithObstaclesDP(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = obstacleGrid[0][i] == 1 ? 0 : dp[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
    // Time Complexity - O(M*N)
    // Space Complexity - O(M*N)

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        L63 obj = new L63();
        System.out.println(obj.uniquePathsWithObstaclesRec(obstacleGrid));
        System.out.println(obj.uniquePathsWithObstaclesMemo(obstacleGrid));
        System.out.println(obj.uniquePathsWithObstaclesDP(obstacleGrid));
    }
}
