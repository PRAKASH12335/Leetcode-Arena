package Striver.DP;

//  DP16 Partition A Set Into Two Subsets With Minimum Absolute Sum Difference

import java.util.Arrays;

public class PartitionSetsIntoTwoSubsetsWithMinimumAbsoluteSumDifference {
    private boolean[][] subsetSumEqualsTarget(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length][target + 1];
        dp[0][0] = true;
        if (nums[0] < target) dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < target; j++) {
                boolean notPick = dp[i - 1][j];
                boolean pick = false;
                if (nums[i] <= j)
                    pick = dp[i - 1][j - nums[i]];
                dp[i][j] = notPick || pick;
            }
        }
        return dp;
    }

    private int minAbsoluteSumDifference(int[] nums) {
        int n = nums.length;
        int target = Arrays.stream(nums).sum();
        int ans = Integer.MAX_VALUE;
        boolean[][] dp = subsetSumEqualsTarget(nums, target);
        for (int i = 0; i <= target / 2; i++) {
            if (dp[n - 1][i] == true) {
                int s1 = i;
                int s2 = target - i;
                ans = Math.min(ans, Math.abs(s2 - s1));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 7};
        PartitionSetsIntoTwoSubsetsWithMinimumAbsoluteSumDifference obj = new PartitionSetsIntoTwoSubsetsWithMinimumAbsoluteSumDifference();
        System.out.println(obj.minAbsoluteSumDifference(nums));
    }
}

// Time Complexity - O(N * N)
// Space Complexity - O(N * N)