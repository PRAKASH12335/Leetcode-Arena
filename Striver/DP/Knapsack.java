package Striver.DP;

// DP 19. 0/1 Knapsack

import java.util.Arrays;

public class Knapsack {
    // Recursion
    public static int helper(int n, int maxWeight, int[] wt, int[] val) {
        if (n == 0 || maxWeight == 0)
            return 0;
        if (wt[n - 1] <= maxWeight)
            return Math.max(val[n - 1] + helper(n - 1, maxWeight - wt[n - 1], wt, val), helper(n - 1, maxWeight, wt, val));
        else
            return helper(n - 1, maxWeight, wt, val);
    }

    private int knapsackRec(int weight, int[] wt, int[] val) {
        int n = wt.length;
        return helper(n, weight, wt, val);
    }
    // Time Complexity - O(2^N)
    // Space Complexity - O(N)

    // Memoization
    private int memoHelper(int n, int w, int[] wt, int[] val, int[][] memo) {
        if (n == 0 || w == 0)
            return 0;
        if (memo[n][w] != -1) return memo[n][w];
        if (wt[n - 1] <= w)
            return memo[n][w] = Math.max(val[n - 1] + helper(n - 1, w - wt[n - 1], wt, val), helper(n - 1, w, wt, val));
        else
            return memo[n][w] = helper(n - 1, w, wt, val);
    }

    private int knapsackMemo(int weight, int[] wt, int[] val) {
        int n = wt.length;
        int[][] memo = new int[n + 1][weight + 1];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));
        return memoHelper(n, weight, wt, val, memo);
    }
    // Time Complexity - O(N*N)
    // Space Complexity - O(N*N)

    // DP
    private int knapsackDP(int w, int[] wt, int[] val) {
        int n = wt.length;
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][w];
    }
    // Time Complexity - O(N*N)
    // Space Complexity - O(N*N)

    public static void main(String[] args) {
        int weight = 6;
        int[] wt = new int[]{3, 2, 5};
        int[] val = new int[]{40, 30, 60};
        Knapsack obj = new Knapsack();
        System.out.println(obj.knapsackRec(weight, wt, val));
        System.out.println(obj.knapsackMemo(weight, wt, val));
        System.out.println(obj.knapsackDP(weight, wt, val));
    }
}
