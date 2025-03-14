package TwoPointers.Medium;

// 523. Continuous Subarray Sum

import java.util.HashMap;

public class L523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int n = nums.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + nums[i]) % k;
            if (map.containsKey(sum)) {
                if (i + 1 - map.get(sum) >= 2) {
                    return true;
                }
            } else
                map.put(sum, i + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23, 2, 6, 4, 7};
        int k = 6;
        System.out.println(new L523().checkSubarraySum(nums, k));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)