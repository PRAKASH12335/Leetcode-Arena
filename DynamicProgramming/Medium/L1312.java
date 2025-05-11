package DynamicProgramming.Medium;

// 1312. Minimum Insertion Steps to Make a String Palindrome

public class L1312 {
    public int minInsertions(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String t = sb.reverse().toString();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return n - dp[n][n]; //  n - Longest palindromic Subsequence
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(new L1312().minInsertions(s));
    }
}

// Time Complexity - O(N*M)
// Space Complexity - O(N*M)