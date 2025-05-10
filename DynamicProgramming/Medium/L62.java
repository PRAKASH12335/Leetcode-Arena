package DynamicProgramming.Medium;

// 62. Unique Paths

public class L62 {
    // Recusion
    public int uniquePathsRec(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        if (m < 1 || n < 1)
            return 0;
        int left = uniquePathsRec(m, n - 1);
        int up = uniquePathsRec(m - 1, n);
        return left + up;
    }
    // Time Complexity - O(2^M*N)
    // Space Complexity - O(M*N)

    // DP
    public int uniquePathsDP(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
    // Time Complexity - O(M*N)
    // Space Complexity - O(M*N)

    public static void main(String[] args) {
        int m = 3, n = 7;
        L62 obj = new L62();
        System.out.println(obj.uniquePathsRec(m, n));
        System.out.println(obj.uniquePathsDP(m, n));
    }
}
