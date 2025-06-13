package Arrays.Medium;

// 6. 3Sum Closest

import java.util.Arrays;

public class L16 {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int closestSum = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }
                if (sum >= target)
                    k--;
                else
                    j++;
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(new L16().threeSumClosest(nums, target));
    }
}

// Time Complexity - O(NlogN + N^2) ~ O(N^2)
// Space Complexity - O(1)