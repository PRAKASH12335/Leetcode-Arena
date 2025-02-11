package TwoPointers.Medium;

// 1493. Longest Subarray of 1's After Deleting One Element

public class L1493 {

    public int longestSubarray(int[] nums) {
        int maxCount = 0, zeroes = 0, start = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                zeroes++;
            }
            if (zeroes > 1) {
                if (nums[start] == 0)
                    zeroes--;
                start++;
            }
            maxCount = Math.max(maxCount, end - start);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1};
        System.out.println(new L1493().longestSubarray(nums));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)