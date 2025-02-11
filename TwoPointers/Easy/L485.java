package TwoPointers.Easy;

// 485. Max Consecutive Ones

public class L485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(new L485().findMaxConsecutiveOnes(nums));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)