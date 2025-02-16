package Greedy.Medium;

// 45. Jump Game II

public class L45 {
    public int jump(int[] nums) {
        int jumps = 0, curr = 0, maxReach = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, nums[i] + i);
            if (i == curr) {
                jumps++;
                curr = maxReach;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new L45().jump(nums));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)