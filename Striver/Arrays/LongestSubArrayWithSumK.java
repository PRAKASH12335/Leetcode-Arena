package Striver.Arrays;

// Longest Subarray with given Sum K(Positives)

public class LongestSubArrayWithSumK {
    public int longestSubarray(int[] nums, int k) {
        int start = 0, maxLength = -1, sum = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            if (sum == k) {
                maxLength = Math.max(maxLength, end - start + 1);
                sum -= nums[start];
                start++;
            }
            while (sum > k) {
                sum -= nums[start];
                start++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;
        System.out.println(new LongestSubArrayWithSumK().longestSubarray(nums, k));
    }
}

// Time Complexity - O(N)
// Time Complexity - O(1)