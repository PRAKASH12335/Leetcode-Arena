package DynamicProgramming.Medium;

// 198. House Robber

import java.util.Arrays;

public class L198 {
    // Recursion
    private int helper(int idx, int[] nums) {
        if (idx >= nums.length) return 0;
        int pick = nums[idx] + helper(idx + 2, nums);
        int notPick = helper(idx + 1, nums);
        return Math.max(pick, notPick);
    }

    public int robRec(int[] nums) {
        int n = nums.length;
        return helper(0, nums);
    }
    // Time Complexity - O(2^N)
    // Space Complexity - O(N)

    // Memoization
    private int memoHelper(int idx, int[] nums, int[] memo) {
        if (idx >= nums.length) return 0;
        if (memo[idx] != -1) return memo[idx];
        int pick = nums[idx] + memoHelper(idx + 2, nums, memo);
        int notPick = memoHelper(idx + 1, nums, memo);
        return memo[idx] = Math.max(pick, notPick);
    }

    public int robMemo(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return memoHelper(0, nums, memo);
    }
    // Time Complexity - O(N)
    // Space Complexity - O(N)

    // DP
    public int robDP(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[n - 1] = nums[n - 1];
        dp[n - 2] = Math.max(nums[n - 1], nums[n - 2]);
        for (int i = n - 3; i >= 0; i--) {
            int pick = nums[i] + dp[i + 2];
            int notPick = dp[i + 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[0];
    }
    // Time Complexity - O(N)
    // Space Complexity - O(N)

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        L198 obj = new L198();
        System.out.println(obj.robRec(nums));
        System.out.println(obj.robMemo(nums));
        System.out.println(obj.robDP(nums));
    }
}
