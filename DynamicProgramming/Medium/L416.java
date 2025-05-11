package DynamicProgramming.Medium;

// 416. Partition Equal Subset Sum

import java.util.Arrays;

public class L416 {
    // DP
    private boolean helper(int[] nums, int target) {
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

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 0)
            return helper(nums, sum / 2);
        else
            return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(new L416().canPartition(nums));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)