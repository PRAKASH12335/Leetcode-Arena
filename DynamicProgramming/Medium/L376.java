package DynamicProgramming.Medium;

// 376. Wiggle Sequence

public class L376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0)
            return 0;
        int increasing = 1, decreasing = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                increasing = decreasing + 1;
            } else if (nums[i] < nums[i - 1]) {
                decreasing = increasing + 1;
            }
        }
        return Math.max(increasing, decreasing);
    }

    public static void main(String[] args) {
        int[] nums = {6, 4, 7, 5, 2};
        System.out.println(new L376().wiggleMaxLength(nums));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)