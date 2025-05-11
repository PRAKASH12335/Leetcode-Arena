package DynamicProgramming.Medium;

// 1143. Longest Common Subsequence

import java.util.Arrays;

public class L1143 {
    // Recursion
    private int LCSHelper(String text1, String text2, int m, int n) {
        if (m < 0 || n < 0)
            return 0;
        if (text1.charAt(m) == text2.charAt(n))
            return 1 + LCSHelper(text1, text2, m - 1, n - 1);
        else
            return Math.max(LCSHelper(text1, text2, m - 1, n), LCSHelper(text1, text2, m, n - 1));
    }

    public int longestCommonSubsequenceRec(String text1, String text2) {
        return LCSHelper(text1, text2, text1.length() - 1, text2.length() - 1);
    }
    // Time Complexity - O(2^M *2^N)
    // Space Complexity - O(N * N)

    // Memoization
    private int LCSHelperMemo(String text1, String text2, int m, int n, int[][] memo) {
        if (m < 0 || n < 0)
            return 0;
        if (memo[m][n] != -1) return memo[m][n];
        if (text1.charAt(m) == text2.charAt(n))
            return memo[m][n] = 1 + LCSHelperMemo(text1, text2, m - 1, n - 1, memo);
        else
            return memo[m][n] = Math.max(LCSHelperMemo(text1, text2, m - 1, n, memo), LCSHelperMemo(text1, text2, m, n - 1, memo));
    }

    public int longestCommonSubsequenceMemo(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] memo = new int[m][n];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));
        return LCSHelperMemo(text1, text2, text1.length() - 1, text2.length() - 1, memo);
    }
    // Time Complexity - O(N*M)
    // Space Complexity - O(N*M) + O(N+M)

    // DP
    public int longestCommonSubsequenceDP(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
    // Time Complexity - O(N*M)
    // Space Complexity - O(N*M)

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        L1143 obj = new L1143();
        System.out.println(obj.longestCommonSubsequenceRec(text1, text2));
        System.out.println(obj.longestCommonSubsequenceMemo(text1, text2));
        System.out.println(obj.longestCommonSubsequenceDP(text1, text2));
    }
}
