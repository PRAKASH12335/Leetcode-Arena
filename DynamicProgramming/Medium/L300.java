package DynamicProgramming.Medium;

// 300. Longest Increasing Subsequence

import java.util.Arrays;

public class L300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int maxi = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxi < dp[i]) {
                maxi = dp[i];
            }
        }
        return maxi;
    }
    // Time Complexity - O(N*N)
    // Space Complexity - O(N)

    public int lengthOfLISBinarySearch(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > dp[length - 1]) {
                dp[length] = nums[i];
                length++;
            } else {
                int index = Arrays.binarySearch(dp, 0, length, nums[i]);
//                System.out.println(nums[i]);
//                System.out.println(index);
                if (index < 0) {
                    index = -(index + 1);
                }
                dp[index] = nums[i];
            }
        }
        return length;
    }
    // Time Complexity - O(N * logN)
    // Space Complexity - O(N)

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        L300 obj = new L300();
        System.out.println(obj.lengthOfLIS(nums));
        System.out.println(obj.lengthOfLISBinarySearch(nums));
    }
}