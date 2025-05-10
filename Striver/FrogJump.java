package Striver;

// DP 3. Frog Jump

import java.util.Arrays;

public class FrogJump {
    // Recursion
    private int helper(int idx, int[] heights) {
        if (idx == 0)
            return 0;
        int step1 = Math.abs(heights[idx] - heights[idx - 1]) + helper(idx - 1, heights);
        int step2 = Integer.MAX_VALUE;
        if (idx > 1)
            step2 = Math.abs(heights[idx] - heights[idx - 2]) + helper(idx - 2, heights);
        return Math.min(step1, step2);
    }

    private int frogJumpRec(int[] heights) {
        int n = heights.length;
        return helper(n - 1, heights);
    }
    // Time Complexity - O(2^N)
    // Space Complexity - O(N)

    // Recursion
    private int memoHelper(int idx, int[] heights, int[] memo) {
        if (idx == 0)
            return 0;
        if (memo[idx] != -1) return memo[idx];
        int step1 = Math.abs(heights[idx] - heights[idx - 1]) + memoHelper(idx - 1, heights, memo);
        int step2 = Integer.MAX_VALUE;
        if (idx > 1)
            step2 = Math.abs(heights[idx] - heights[idx - 2]) + memoHelper(idx - 2, heights, memo);
        return memo[idx] = Math.min(step1, step2);
    }

    private int frogJumpMemo(int[] heights) {
        int n = heights.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return memoHelper(n - 1, heights, memo);
    }
    // Time Complexity - O(N)
    // Space Complexity - O(N)

    private int frogJumpDP(int[] heights) {
        int n = heights.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int step1 = Math.abs(heights[i] - heights[i - 1]) + dp[i - 1];
            int step2 = Integer.MAX_VALUE;
            if (i > 1)
                step2 = Math.abs(heights[i] - heights[i - 2]) + dp[i - 2];
            dp[i] = Math.min(step1, step2);
        }
        return dp[n - 1];
    }
    // Time Complexity - O(N)
    // Space Complexity - O(N)

    public static void main(String[] args) {
        int[] heights = new int[]{30, 10, 60, 10, 60, 50};
        FrogJump obj = new FrogJump();
        System.out.println(obj.frogJumpRec(heights));
        System.out.println(obj.frogJumpMemo(heights));
        System.out.println(obj.frogJumpDP(heights));
    }
}