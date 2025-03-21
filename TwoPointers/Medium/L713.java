package TwoPointers.Medium;

// 713. Subarray Product Less Than K

public class L713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int product = 1, count = 0, start = 0, end = 0;

        while (end < nums.length) {
            product *= nums[end];
            while (product >= k && start < nums.length) {
                product /= nums[start];
                start++;
            }
            if (product < k)
                count = count + (end - start + 1);
            end++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        System.out.println(new L713().numSubarrayProductLessThanK(nums, k));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)