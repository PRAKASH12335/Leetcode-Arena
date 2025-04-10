package BinarySearch.Medium;

// 153. Find Minimum in Rotated Sorted Array

public class L153 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = nums.length - 1, ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]);
                low = mid + 1;
            } else {
                ans = Math.min(ans, nums[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(new L153().findMin(nums));
    }
}

// Time Complexity - O(log N)
// Space Complexity - O(1)