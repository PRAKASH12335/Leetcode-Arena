package Striver.DP;

// DP 18. Count Partitions With Given Difference

import java.util.Arrays;

public class CountPartitionsWithGivenDifference {
    // Recursion
    private int helper(int[] nums, int sum, int index) {
        if (index == 0) {
            if (sum == 0 && nums[0] == 0) return 2;
            if (sum == 0 || sum == nums[0]) return 1;
            return 0;
        }
        int notPick = helper(nums, sum, index - 1);
        int pick = 0;
        if (sum >= nums[index])
            pick = helper(nums, sum - nums[index], index - 1);
        return pick + notPick;
    }

    private int countSubsetWithDiffRec(int[] nums, int diff) {
        // s1 + s2 = sum
        // s1 - s2 = diff
        // s1 = diff + s2
        // diff + s2 + s2 = sum
        // s2 = (sum - diff)/2
        int sum = Arrays.stream(nums).sum();
        if (sum - diff < 0 || (sum - diff) % 2 == 1)
            return 0;
        System.out.println("target : " + (sum - diff) / 2);
        return helper(nums, (sum - diff) / 2, nums.length - 1);
    }
    // Time Complexity - O(2^N)
    // Space Complexity - O(N)

    // DP
    private int countSubsetWithDiffDP(int[] nums, int diff) {
        int sum = Arrays.stream(nums).sum();
        if (sum - diff < 0 || (sum - diff) % 2 == 1)
            return 0;
        System.out.println("target : " + (sum - diff) / 2);
        int target = (sum - diff) / 2;
        int[][] dp = new int[nums.length][target + 1];
        if (nums[0] == 0) dp[0][0] = 2; // cases : pick and notpick
        else dp[0][0] = 1; // 1 case : not pick
        if (nums[0] != 0 && nums[0] <= target) dp[0][nums[0]] = 1; // 1 case pick case

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                int notPick = dp[i - 1][j];
                int pick = 0;
                if (j >= nums[i])
                    pick = dp[i - 1][j - nums[i]];
                ;
                dp[i][j] = pick + notPick;
            }
        }
        return dp[nums.length - 1][target];
    }
    // Time Complexity - O(N * N)
    // Space Complexity - O(N * N)

    public static void main(String[] args) {
        int nums[] = {5, 2, 6, 4};
        int diff = 3;
        CountPartitionsWithGivenDifference obj = new CountPartitionsWithGivenDifference();
        System.out.println("The number of subsets found are " + obj.countSubsetWithDiffRec(nums, diff));
        System.out.println("The number of subsets found are " + obj.countSubsetWithDiffDP(nums, diff));
    }
}
