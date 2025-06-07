package DynamicProgramming.Hard;

// 132. Palindrome Partitioning II

import java.util.Arrays;

public class L132 {
    public boolean isPalindrome(int i, int j, String temp) {
        while (i < j) {
            if (temp.charAt(i++) != temp.charAt(j--))
                return false;
        }
        return true;
    }

    // Recursion
    public int recursionHelper(int i, String s) {
        if (i == s.length())
            return 0;
        int ans = Integer.MAX_VALUE;
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(i, j, s)) {
                int cost = 1 + recursionHelper(j + 1, s);
                ans = Math.min(cost, ans);
            }
        }
        return ans;
    }

    public int minCutRecursion(String s) {
        if (s.length() == 0)
            return 0;
        return recursionHelper(0, s) - 1;
    }
    // Time Complexity - O(2^N)
    // Space Complexity - O(N)

    // Memoization
    public int memoHelper(int i, String s, int[] memo) {
        if (i == s.length())
            return 0;
        if (memo[i] != -1) return memo[i];
        int ans = Integer.MAX_VALUE;
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(i, j, s)) {
                int cost = 1 + memoHelper(j + 1, s, memo);
                ans = Math.min(cost, ans);
            }
        }
        return memo[i] = ans;
    }

    public int minCutMemo(String s) {
        if (s.length() == 0)
            return 0;
        int n = s.length();
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return memoHelper(0, s, memo) - 1;
    }
    // Time Complexity - O(N*N)
    // Space Complexity - O(N)

    // DP
    public int minCutDP(String s) {
        if (s.length() == 0)
            return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int ans = Integer.MAX_VALUE;
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(i, j, s)) {
                    int cost = 1 + dp[j + 1];
                    ans = Math.min(cost, ans);
                }
            }
            dp[i] = ans;
        }
        return dp[0] - 1;
    }
    // Time Complexity - O(N*N)
    // Space Complexity - O(N)

    public static void main(String[] args) {
        String str = "bababcbadcede";
        L132 obj = new L132();
        System.out.println(obj.minCutRecursion(str));
        System.out.println(obj.minCutMemo(str));
        System.out.println(obj.minCutDP(str));
    }
}