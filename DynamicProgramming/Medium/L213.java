package DynamicProgramming.Medium;

// 213. House Robber II

public class L213 {
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

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] temp1 = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            temp1[i] = nums[i];
        }
        int[] temp2 = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            temp2[i] = nums[i + 1];
        }
        return Math.max(robDP(temp1), robDP(temp2));
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new L213().rob(nums));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)