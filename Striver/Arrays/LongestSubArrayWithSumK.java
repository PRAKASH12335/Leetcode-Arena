package Striver.Arrays;

// Longest Subarray with given Sum K(Positives)

import java.util.HashMap;
import java.util.Map;

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

    // Time Complexity - O(N)
    // Space Complexity - O(1)

    public int longestSubarrayNegatives(int[] nums, int k) {
        int n = nums.length;
        int sum = 0, maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (sum == k)
                maxLen = Math.max(maxLen, i + 1);
            if (map.containsKey(sum - k))
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            if (!map.containsKey(sum))
                map.put(sum, i);
        }
        return maxLen;
    }

    // Time Complexity - O(N)
    // Space Complexity - O(N)

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;
        LongestSubArrayWithSumK obj = new LongestSubArrayWithSumK();
        System.out.println(obj.longestSubarray(nums, k));
        int[] nums1 = {10, 5, 2, 7, 1, -10};
        System.out.println(obj.longestSubarrayNegatives(nums1, k));
    }
}
