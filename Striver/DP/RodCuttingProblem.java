package Striver.DP;

// DP 24. Rod Cutting Problem

import java.util.Arrays;

public class RodCuttingProblem {
    // Recursion
    private int helper(int[] price, int index, int n) {
        if (index == 0)
            return price[0] * n;
        int notTake = helper(price, index - 1, n);
        int rodLength = index + 1;
        int take = Integer.MIN_VALUE;
        if (rodLength <= n)
            take = price[index] + helper(price, index, n - rodLength);
        return Math.max(take, notTake);
    }

    public int cutRodRec(int price[], int n) {
        return helper(price, price.length - 1, n);
    }
    // Time Complexity: O(2^N)
    // Space Complexity: O(N)

    // Memoization
    private int memoHelper(int[] price, int index, int n, int[][] memo) {
        if (index == 0)
            return price[0] * n;
        if (memo[index][n] != -1) return memo[index][n];
        int notTake = memoHelper(price, index - 1, n, memo);
        int rodLength = index + 1;
        int take = Integer.MIN_VALUE;
        if (rodLength <= n)
            take = price[index] + memoHelper(price, index, n - rodLength, memo);
        return memo[index][n] = Math.max(take, notTake);
    }

    public int cutRodMemo(int price[], int n) {
        int[][] memo = new int[n][n + 1];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));
        return memoHelper(price, price.length - 1, n, memo);
    }
    // Time Complexity: O(N*N)
    // Space Complexity: O(N*N) + O(N)

    // DP
    private int cutRodDP(int[] price, int n) {
        int[][] dp = new int[n][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = price[0] * i;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                int notTake = dp[i - 1][j];
                int rodLength = i + 1;
                int take = Integer.MIN_VALUE;
                if (rodLength <= j)
                    take = price[i] + dp[i][j - rodLength];
                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[n - 1][n];
    }
    // Time Complexity: O(N*N)
    // Space Complexity: O(N*N)

    public static void main(String[] args) {
        int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
        RodCuttingProblem obj = new RodCuttingProblem();
        System.out.println(obj.cutRodRec(arr, arr.length));
        System.out.println(obj.cutRodMemo(arr, arr.length));
        System.out.println(obj.cutRodDP(arr, arr.length));
    }
}
