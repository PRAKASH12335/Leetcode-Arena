package Striver.DP;

//DP 17. Counts Subsets with Sum K

import java.util.Arrays;

public class CountsSubsetswithSumK {
    // Recursion
    private int helper(int[] nums, int k, int index) {
        if (k == 0) return 1;
        if (index == 0) return nums[index] == k ? 1 : 0;
        int notPick = helper(nums, k, index - 1);
        int pick = 0;
        if (nums[index] <= k)
            pick = helper(nums, k - nums[index], index - 1);
        return pick + notPick;
    }

    private int countsSubsetswithSumKRec(int[] nums, int k) {
        return helper(nums, k, nums.length - 1);
    }
    // Time Complexity - O(2^N)
    // Space Complexity - O(N * N)

    // Memoization
    private int memoHelper(int[] nums, int k, int index, int[][] memo) {
        if (k == 0) return 1;
        if (index == 0) return nums[index] == k ? 1 : 0;
        if (memo[index][k] != -1) return 1;
        int notPick = helper(nums, k, index - 1);
        int pick = 0;
        if (nums[index] <= k)
            pick = helper(nums, k - nums[index], index - 1);
        return memo[index][k] = pick + notPick;
    }

    private int countsSubsetswithSumKMemo(int[] nums, int k) {
        int[][] memo = new int[nums.length][k + 1];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));
        return helper(nums, k, nums.length - 1);
    }
    // Time Complexity - O(N * N)
    // Space Complexity - O(N * N)

    private int countsSubsetswithSumKDP(int[] nums, int k) {
        int[][] dp = new int[nums.length][k + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 1;
        }
        if (nums[0] == k) dp[0][k] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                int notPick = dp[i - 1][j];
                int pick = 0;
                if (nums[i] <= k)
                    pick = dp[i - 1][k - nums[i]];
                dp[i][j] = pick + notPick;
            }
        }
        return dp[nums.length - 1][k];
    }
    // Time Complexity - O(N * N)
    // Space Complexity - O(N * N)

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3};
        int k = 5;
        CountsSubsetswithSumK obj = new CountsSubsetswithSumK();
        System.out.println(obj.countsSubsetswithSumKRec(nums, k));
        System.out.println(obj.countsSubsetswithSumKMemo(nums, k));
        System.out.println(obj.countsSubsetswithSumKDP(nums, k));
    }
}
