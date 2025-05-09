package DynamicProgramming.Easy;

// 746. Min Cost Climbing Stairs

import java.util.Arrays;

public class L746 {
    // Recursion
    private int helper(int idx, int end, int[] cost) {
        if (idx > end) return 0;
        int step1 = cost[idx] + helper(idx + 1, end, cost);
        int step2 = cost[idx] + helper(idx + 2, end, cost);
        return Math.min(step1, step2);
    }

    public int minCostClimbingStairsRec(int[] cost) {
        int n = cost.length;
        return Math.min(helper(0, n - 1, cost), helper(1, n - 1, cost));
    }
    // Time Complexity - O(2^N)
    // Space Complexity - O(N)

    // Memoization
    private int memoHelper(int idx, int end, int[] cost, int[] memo) {
        if (idx > end) return 0;
        if (memo[idx] != -1) return memo[idx];
        int step1 = cost[idx] + helper(idx + 1, end, cost);
        int step2 = cost[idx] + helper(idx + 2, end, cost);
        memo[idx] = Math.min(step1, step2);
        return memo[idx];
    }

    public int minCostClimbingStairsMemo(int[] cost) {
        int n = cost.length;
        int[] memo = new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(memoHelper(0, n - 1, cost, memo), memoHelper(1, n - 1, cost, memo));
    }
    // Time Complexity - O(N)
    // Space Complexity - O(N)

    // DP
    public int minCostClimbingStairsDP(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int step1 = cost[i];
            if (i > 0)
                step1 += dp[i - 1];
            int step2 = cost[i];
            if (i > 1)
                step2 += dp[i - 2];
            dp[i] = Math.min(step1, step2);
        }
        return Math.min(dp[n - 2], dp[n - 1]);
    }
    // Time Complexity - O(N)
    // Space Complexity - O(N)

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        L746 obj = new L746();
        System.out.println(obj.minCostClimbingStairsRec(cost));
        System.out.println(obj.minCostClimbingStairsMemo(cost));
        System.out.println(obj.minCostClimbingStairsDP(cost));
    }
}
