package Striver.DP;

// Frog Jump with K Distance

import java.util.Arrays;

public class FrogJumpWithKDistance {
    // Recursion
    private int helper(int idx, int[] heights, int k) {
        if (idx == 0) return 0;
        int minSteps = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (idx - j >= 0) {
                int jump = Math.abs(heights[idx] - heights[idx - j]) + helper(idx - j, heights, k);
                minSteps = Math.min(jump, minSteps);
            }
        }
        return minSteps;
    }

    private int frogJumpWithKDistance(int[] heights, int k) {
        int n = heights.length;
        return helper(n - 1, heights, k);
    }

    // Memoization
    private int memoHelper(int idx, int[] heights, int k, int[] memo) {
        if (idx == 0) return 0;
        if (memo[idx] != -1) return memo[idx];
        int minSteps = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (idx - j >= 0) {
                int jump = Math.abs(heights[idx] - heights[idx - j]) + memoHelper(idx - j, heights, k, memo);
                minSteps = Math.min(jump, minSteps);
            }
        }
        return memo[idx] = minSteps;
    }

    private int frogJumpWithKDistanceMemo(int[] heights, int k) {
        int n = heights.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return memoHelper(n - 1, heights, k, memo);
    }
    // Time Complexity - O(N * K)
    // Space Complexity - O(N)

    // DP
    private int frogJumpWithKDistanceDP(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = Math.abs(heights[i] - heights[i - j]) + dp[i - j];
                    minSteps = Math.min(minSteps, jump);
                }
            }
            dp[i] = minSteps;
        }
        return dp[n - 1];
    }
    // Time Complexity - O(N * K)
    // Space Complexity - O(N)

    public static void main(String[] args) {
        int[] heights = new int[]{30, 10, 60, 10, 60, 50};
        FrogJumpWithKDistance obj = new FrogJumpWithKDistance();
        System.out.println(obj.frogJumpWithKDistance(heights, 3));
        System.out.println(obj.frogJumpWithKDistanceMemo(heights, 3));
        System.out.println(obj.frogJumpWithKDistanceDP(heights, 3));
    }
}
