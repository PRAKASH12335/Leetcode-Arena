package Striver.DP;

// DP 27. Longest Common Substring

public class LongestCommonSubstring {
    private int longestCommonSubstring(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                } else
                    dp[i][j] = 0;

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "abcdxyz", s2 = "xyzabcd";
        System.out.println(new LongestCommonSubstring().longestCommonSubstring(s1, s2));
    }
}

// Time Complexity - O(N*M)
// Space Complexity - O(N*M)