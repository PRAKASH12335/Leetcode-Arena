package Striver.DP;

// DP 48. Matrix Chain Multiplication

import java.util.Arrays;

public class MatrixChainMultiplication {
    // Recursion
    public int recusrionHelper(int i, int j, int[] nums) {
        if (i == j) return 0;
        int ans = (int) 1e9;
        for (int k = i; k < j; k++) {
            int steps = nums[i - 1] * nums[k] * nums[j] +
                    recusrionHelper(i, k, nums) +
                    recusrionHelper(k + 1, j, nums);
            ans = Math.min(steps, ans);
        }
        return ans;
    }

    public int matrixChainMultiplicationRecursion(int[] nums) {
        int n = nums.length;
        return recusrionHelper(1, n - 1, nums);
    }
    // Time Complexity - O(2^N)
    // Space Complexity - O(N)

    // Memoization
    public int memoHelper(int i, int j, int[] nums, int[][] memo) {
        if (i == j) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int ans = (int) 1e9;
        for (int k = i; k < j; k++) {
            int steps = nums[i - 1] * nums[k] * nums[j] +
                    memoHelper(i, k, nums, memo) +
                    memoHelper(k + 1, j, nums, memo);
            ans = Math.min(steps, ans);
        }
        return memo[i][j] = ans;
    }

    public int matrixChainMultiplicationMemo(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));
        return memoHelper(1, n - 1, nums, memo);
    }
    // Time Complexity - O(N^3)
    // Space Complexity - O(N*N)

    public int matrixChainMultiplicationDP(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int ans = (int) 1e9;
                for (int k = i; k < j; k++) {
                    int steps = nums[i - 1] * nums[k] * nums[j] +
                            dp[i][k] + dp[k + 1][j];
                    ans = Math.min(steps, ans);
                }
                dp[i][j] = ans;
            }
        }
        return dp[1][n - 1];
    }
    // Time Complexity - O(N^3)
    // Space Complexity - O(N*N)

    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 40, 30};
        MatrixChainMultiplication mcm = new MatrixChainMultiplication();
        System.out.println(mcm.matrixChainMultiplicationRecursion(nums));
        System.out.println(mcm.matrixChainMultiplicationMemo(nums));
        System.out.println(mcm.matrixChainMultiplicationDP(nums));
    }
}