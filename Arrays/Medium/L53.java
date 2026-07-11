package Arrays.Medium;

// 53. Maximum Subarray

import java.util.Arrays;

public class L53 {

    public int maxSubArray(int[] nums) {
        int maxi = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > maxi)
                maxi = sum;
            if (sum < 0)
                sum = 0;
        }
        return maxi;
    }

    public int[] maxSubArrayIndexes(int[] nums) {
        int maxi = Integer.MIN_VALUE, sum = 0;
        int[] ans = new int[2];
        int start = -1, end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) start = i;
            sum += nums[i];
            if (sum > maxi) {
                maxi = sum;
                ans[0] = start;
                ans[1] = i;
            }
            if (sum < 0)
                sum = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        L53 obj = new L53();
        System.out.println(obj.maxSubArray(nums));
        int[] ind = obj.maxSubArrayIndexes(nums);
        Arrays.stream(ind).forEach(a -> System.out.print(a + " "));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)