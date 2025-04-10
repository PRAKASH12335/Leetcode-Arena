package BinarySearch.Medium;

// 81. Search in Rotated Sorted Array II

public class L81 {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if (nums[mid] <= target && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        System.out.println(new L81().search(nums, target));
    }
}

// Time Complexity - O(log N)
// Space Complexity - O(1)