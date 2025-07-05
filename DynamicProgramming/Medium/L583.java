package DynamicProgramming.Medium;

// 583. Delete Operation for Two Strings

import java.util.Arrays;

public class L583 {
    // Memoization
    public int lcsHelperMemo(String word1, String word2, int m, int n, int[][] memo) {
        if (m < 0 || n < 0)
            return 0;
        if (memo[m][n] != -1)
            return memo[m][n];
        if (word1.charAt(m) == word2.charAt(n)) {
            return memo[m][n] = 1 + lcsHelperMemo(word1, word2, m - 1, n - 1, memo);
        } else {
            return memo[m][n] = Math.max(lcsHelperMemo(word1, word2, m, n - 1, memo), lcsHelperMemo(word1, word2, m - 1, n, memo));
        }
    }

    public int lcsMemo(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] memo = new int[m][n];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));
        return lcsHelperMemo(word1, word2, m - 1, n - 1, memo);
    }

    public int minDistanceMemo(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int lcs = lcsMemo(word1, word2);
        return m + n - 2 * lcs;
    }
    // Time Complexity: O(M * N)
    // Space Complexity: O(M * N)

    // DP
    public int lcs(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    public int minDistanceDP(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int lcs = lcs(word1, word2);
        return m + n - 2 * lcs;
    }

    public static void main(String[] args) {
        String word1 = "sea", word2 = "eat";
        System.out.println(new L583().minDistanceMemo(word1, word2));
        System.out.println(new L583().minDistanceDP(word1, word2));
    }
}

// Time Complexity: O(M * N)
// Space Complexity: O(M * N)