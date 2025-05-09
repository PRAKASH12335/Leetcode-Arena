package DynamicProgramming.Easy;

// 70. Climbing Stairs

import java.util.Arrays;

public class L70 {
    // Recursion
    public int climbStairsRecursion(int n) {
        if (n <= 1)
            return 1;
        return climbStairsRecursion(n - 1) + climbStairsRecursion(n - 2);
    }
    // Time Complexity - O(2^N)
    // Space Complexity - O(N)

    // Memoization
    public int helper(int n, int[] memo) {
        if (n <= 1)
            return 1;
        if (memo[n] != -1)
            return memo[n];
        memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
        return memo[n];
    }

    public int climbStairsMemo(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return helper(n, memo);
    }
    // Time Complexity - O(N) + O(N)
    // Space Complexity - O(N)

    // DP
    public int climbStairsDP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    // Time Complexity - O(N)
    // Space Complexity - O(N)

    public static void main(String[] args) {
        int n = 5;
        L70 obj = new L70();
        System.out.println(obj.climbStairsRecursion(n));
        System.out.println(obj.climbStairsMemo(n));
        System.out.println(obj.climbStairsDP(n));
    }
}