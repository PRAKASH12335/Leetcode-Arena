package BinarySearch.Easy;

// 35. Search Insert Position

public class L35 {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1, ans = nums.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println(new L35().searchInsert(nums, target));

    }
}

// Time Complexity - O(log N)
// Space Complexity - O(1)