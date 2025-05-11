package Striver.DP;

// Subset Sum Equals to Target

import java.util.Arrays;

public class SubsetSumEqualstoTarget {
    // Recursion
    private boolean helper(int[] nums, int target, int index) {
        if (target == 0) return true;
        if (index == 0) return (nums[0] == target);
        boolean notTake = helper(nums, target, index - 1);
        boolean take = false;
        if (target >= nums[index]) {
            take = helper(nums, target - nums[index], index - 1);
        }
        return take || notTake;
    }

    private boolean subsetSumEqualsKRec(int[] nums, int target) {
        return helper(nums, target, nums.length - 1);
    }
    // Time Complexity - O(2^N)
    // Space Complexity - O(N)

    // Memoization
    private boolean memoHelper(int[] nums, int target, int index, int[][] memo) {
        if (target == 0) return true;
        if (index == 0) return (nums[0] == target);
        if (memo[index][target] != -1) return memo[index][target] == 1 ? true : false;
        boolean notTake = memoHelper(nums, target, index - 1, memo);
        boolean take = false;
        if (target >= nums[index]) {
            take = memoHelper(nums, target - nums[index], index - 1, memo);
        }
        memo[index][target] = take || notTake ? 1 : 0;
        return take || notTake;
    }

    private boolean subsetSumEqualsKMemo(int[] nums, int target) {
        int[][] memo = new int[nums.length][target + 1];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));
        return memoHelper(nums, target, nums.length - 1, memo);
    }
    // Time Complexity - O(N * N)
    // Space Complexity - O(N * N)

    private boolean subsetSumEqualsKDP(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length][target + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        if (nums[0] < target) dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                boolean notTake = dp[i - 1][j];
                boolean take = false;
                if (j >= nums[i]) {
                    take = dp[i - 1][j - nums[i]];
                }
                dp[i][j] = take || notTake;
            }
        }
        return dp[nums.length - 1][target];
    }
    // Time Complexity - O(N * N)
    // Space Complexity - O(N * N)

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int k = 7;
        SubsetSumEqualstoTarget obj = new SubsetSumEqualstoTarget();
        System.out.println(obj.subsetSumEqualsKRec(nums, k));
        System.out.println(obj.subsetSumEqualsKMemo(nums, k));
        System.out.println(obj.subsetSumEqualsKDP(nums, k));
    }
}