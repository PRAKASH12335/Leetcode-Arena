package Arrays.Medium;

// 334. Increasing Triplet Subsequence

public class L334 {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < first)
                first = nums[i];
            else if (nums[i] > first && nums[i] < second)
                second = nums[i];
            else if (nums[i] > second)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(new L334().increasingTriplet(nums));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)