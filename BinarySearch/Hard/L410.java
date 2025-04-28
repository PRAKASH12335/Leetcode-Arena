package BinarySearch.Hard;

// 410. Split Array Largest Sum

import java.util.Arrays;

public class L410 {
    private int checkPossible(int[] nums, int mid) {
        int sum = 0, cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] <= mid) {
                sum = sum + nums[i];
            } else {
                cnt++;
                sum = nums[i];
            }
        }
        return cnt;
    }

    public int splitArray(int[] nums, int k) {
        if (nums.length < k)
            return -1;
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();
        while (low <= high) {
            int mid = (low + high) / 2;
            if (checkPossible(nums, mid) > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;
        System.out.println(new L410().splitArray(nums, k));
    }
}

// Time Complexity - O(N * log(sum-max+1))
// Space Complexity - O(1)