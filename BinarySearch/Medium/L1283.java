package BinarySearch.Medium;

// 1283. Find the Smallest Divisor Given a Threshold

import java.util.Arrays;

public class L1283 {
    private boolean checkPossible(int[] nums, int mid, int threshold) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += Math.ceil((double) nums[i] / mid);
        }
        return count <= threshold;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = Arrays.stream(nums).max().getAsInt();
        if (threshold < nums.length)
            return -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (checkPossible(nums, mid, threshold)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        System.out.println(new L1283().smallestDivisor(nums, threshold));
    }
}

// Time Complexity - O(N * log(max))
// Space Complexity - O(1)