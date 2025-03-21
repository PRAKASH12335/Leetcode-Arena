package TwoPointers.Medium;

// 560. Subarray Sum Equals K

import java.util.HashMap;

public class L560 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int cnt = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                cnt += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        System.out.println(new L560().subarraySum(nums, k));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)