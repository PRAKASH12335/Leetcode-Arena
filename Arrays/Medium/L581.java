package Arrays.Medium;

// 581. Shortest Unsorted Continuous Subarray

public class L581 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low + 1 < n && nums[low] <= nums[low + 1]) low++;
        while (high > 0 && nums[high] >= nums[high - 1]) high--;

        if (low == n - 1) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        while (low > 0 && min < nums[low - 1]) low--;
        while (high + 1 < n && max > nums[high + 1]) high++;
        return high - low + 1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(new L581().findUnsortedSubarray(nums));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)