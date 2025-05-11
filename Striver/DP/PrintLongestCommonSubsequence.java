package Striver.DP;

// DP 26. Print Longest Common Subsequence

public class PrintLongestCommonSubsequence {
    private String printLCS(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        int i = m, j = n;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1])
                    i--;
                else
                    j--;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s1 = "abcde", s2 = "bdqek";
        PrintLongestCommonSubsequence obj = new PrintLongestCommonSubsequence();
        System.out.println(obj.printLCS(s1, s2));
    }
}

// Time Complexity - O(N*M)
// Space Complexity - O(N*M)