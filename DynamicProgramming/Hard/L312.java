package DynamicProgramming.Hard;

// 312. Burst Balloons

import java.util.Arrays;

public class L312 {
    // Recursion
    public int recursionHelper(int i, int j, int[] nums) {
        if (i > j) return 0;
        int ans = Integer.MIN_VALUE;
        for (int index = i; index <= j; index++) {
            int maxi = nums[i - 1] * nums[index] * nums[j + 1] +
                    recursionHelper(i, index - 1, nums) +
                    recursionHelper(index + 1, j, nums);
            ans = Math.max(maxi, ans);
        }
        return ans;
    }

    public int maxCoinsRecursion(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        for (int i = 1; i <= n; i++) {
            newNums[i] = nums[i - 1];
        }
        newNums[n + 1] = 1;
        return recursionHelper(1, n, newNums);
    }
    // Time Complexity - O(2^N)
    // Space Complexity - O(N)

    // Memoization
    public int memoHelper(int i, int j, int[] nums, int[][] memo) {
        if (i > j) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int ans = Integer.MIN_VALUE;
        for (int index = i; index <= j; index++) {
            int maxi = nums[i - 1] * nums[index] * nums[j + 1] +
                    memoHelper(i, index - 1, nums, memo) +
                    memoHelper(index + 1, j, nums, memo);
            ans = Math.max(maxi, ans);
        }
        return memo[i][j] = ans;
    }

    public int maxCoinsMemo(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        for (int i = 1; i <= n; i++) {
            newNums[i] = nums[i - 1];
        }
        newNums[n + 1] = 1;
        int[][] memo = new int[n + 1][n + 1];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));
        return memoHelper(1, n, newNums, memo);
    }
    // Time Complexity - O(N^3)
    // Space Complexity - O(N*N)

    // DP
    public int maxCoinsDP(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        for (int i = 1; i <= n; i++) {
            newNums[i] = nums[i - 1];
        }
        newNums[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) continue;
                int ans = Integer.MIN_VALUE;
                for (int index = i; index <= j; index++) {
                    int maxi = newNums[i - 1] * newNums[index] * newNums[j + 1] +
                            dp[i][index - 1] + dp[index + 1][j];
                    ans = Math.max(maxi, ans);
                }
                dp[i][j] = ans;
            }
        }
        return dp[1][n];
    }
    // Time Complexity - O(N^3)
    // Space Complexity - O(N*N)

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        L312 obj = new L312();
        System.out.println(obj.maxCoinsRecursion(nums));
        System.out.println(obj.maxCoinsMemo(nums));
        System.out.println(obj.maxCoinsDP(nums));
    }
}