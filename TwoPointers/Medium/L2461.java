package TwoPointers.Medium;

// 2461. Maximum Sum of Distinct Subarrays With Length K

import java.util.HashSet;
import java.util.Set;

public class L2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < k) return -1;
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0;
        long result = 0, currSum = 0;

        while (j < n) {
            while (set.contains(nums[j])) {
                set.remove(nums[i]);
                currSum -= nums[i];
                i++;
            }
            currSum += nums[j];
            set.add(nums[j]);
            if (j - i + 1 == k) {
                result = Math.max(result, currSum);
                set.remove(nums[i]);
                currSum -= nums[i];
                i++;
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;
        System.out.println(new L2461().maximumSubarraySum(nums, k));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)