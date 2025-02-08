package Misc;

// 31. Next Permutation

import java.util.Arrays;

public class L31 {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i;
        for (i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i])
                break;
        }
        if (i == 0) {
            Arrays.sort(nums);
            return;
        }

        int temp = i, big = i, small = i - 1;
        // 1    2    5    4    3
        //    small  i        n-1
        //          temp
        //          big
        for (i = n - 1; i >= big; i--) {
            if (nums[i] < nums[temp] && nums[i] > nums[small]) {
                temp = i;
            }
        }
        int temp1 = nums[small];
        nums[small] = nums[temp];
        nums[temp] = temp1;
        // 1    3    5    4    2
        //    small
        Arrays.sort(nums, small + 1, n);
        // 1    3    2    4    5
        Arrays.stream(nums).forEach(a -> System.out.print(a + " "));
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 4, 3};
        new L31().nextPermutation(nums);
    }
}

// Time Complexity - O(N * logN)
// Space Complexity - O(1)