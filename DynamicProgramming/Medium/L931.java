package DynamicProgramming.Medium;

// 931. Minimum Falling Path Sum

public class L931 {
    // Recursion
    private int helper(int[][] matrix, int i, int j) {
        if (j < 0 || j >= matrix.length) return Integer.MAX_VALUE;
        if (i == 0) return matrix[0][j];
        int s = helper(matrix, i - 1, j);
        int ld = helper(matrix, i - 1, j - 1);
        int rd = helper(matrix, i - 1, j + 1);
        return Math.min(s, Math.min(ld, rd)) + matrix[i][j];
    }

    public int minFallingPathSumRec(int[][] matrix) {
        int n = matrix.length;
        if (n == 1)
            return matrix[0][0];
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, helper(matrix, n - 1, j));
        }
        return min;
    }
    // Time Complexity - O(3 ^ N)
// Space Complexity - O(N)

    // DP
    public int minFallingPathSumDP(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) return matrix[0][0];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int ld = Integer.MAX_VALUE, rd = Integer.MAX_VALUE;
                int v = matrix[i][j] + dp[i - 1][j];
                if (j > 0)
                    ld = matrix[i][j] + dp[i - 1][j - 1];
                if (j < n - 1)
                    rd = matrix[i][j] + dp[i - 1][j + 1];
                dp[i][j] = Math.min(v, Math.min(ld, rd));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        L931 obj = new L931();
        System.out.println(obj.minFallingPathSumRec(matrix));
        System.out.println(obj.minFallingPathSumDP(matrix));
    }
}

// Time Complexity - O(N * N)
// Space Complexity - O(N * N)