package TwoPointers.Easy;

// 724. Find Pivot Index

import java.util.Arrays;

public class L724 {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            rightSum += nums[i];
//        }
        int rightSum = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0)
                leftSum += nums[i - 1];
            rightSum -= nums[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(new L724().pivotIndex(nums));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)