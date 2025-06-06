package DynamicProgramming.Medium;

// 1277. Count Square Submatrices with All Ones

public class L1277 {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int ans = 0;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == 1 ? 1 : 0;
                } else {
                    dp[i][j] = matrix[i][j] == 1 ? Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1 : 0;
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };
        System.out.println(new L1277().countSquares(matrix));
    }
}

// Time Complexity - O(M*N)
// Space Complexity - O(M*N)