package Greedy.Medium;

// 55. Jump Game

public class L55 {
    public boolean canJump(int[] nums) {
        int n = nums.length, max = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] + i >= max) {
                max = i;
            }
        }
        if (max == 0)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new L55().canJump(nums));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)