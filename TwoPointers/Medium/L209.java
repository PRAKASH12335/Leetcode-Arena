package TwoPointers.Medium;

// 209. Minimum Size Subarray Sum

public class L209 {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0, minLength = Integer.MAX_VALUE, start = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                minLength = Math.min(minLength, i - start + 1);
                sum -= nums[start];
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(new L209().minSubArrayLen(target, nums));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)