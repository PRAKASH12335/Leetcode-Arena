package TwoPointers.Medium;

// 974. Subarray Sums Divisible by K

import java.util.HashMap;

public class L974 {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = (sum % k + k) % k;
            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        System.out.println(new L974().subarraysDivByK(nums, k));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)