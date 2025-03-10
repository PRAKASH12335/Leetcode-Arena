package Backtracking.Medium;

// 377. Combination Sum IV

import java.util.Arrays;

public class L377 {
    private int solve(int[] nums, int target, int[][] dp, int index) {
        if (index >= nums.length || target < 0)
            return 0;
        if (target == 0) {
            return 1;
        }
        if (dp[index][target] != -1)
            return dp[index][target];
        int take = solve(nums, target - nums[index], dp, 0);
        int notTake = solve(nums, target, dp, index + 1);
        return dp[index][target] = take + notTake;
    }

    public int combinationSum4(int[] nums, int target) {
        int[][] dp = new int[nums.length + 1][target + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(nums, target, dp, 0);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(new L377().combinationSum4(nums, target));
    }
}

// Time Complexity - O(N*M)
// Space Complexity - O(N*M)