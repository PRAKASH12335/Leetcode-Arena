package HashMap.Easy;

// 1512. Number of Good Pairs

import java.util.HashMap;

public class L1512 {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int ans = 0;
        for (int value : map.values()) {
            if (value >= 2) {
                ans += (value * (value - 1)) / 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3};
        System.out.println(new L1512().numIdenticalPairs(nums));
    }
}

// Time complexity - O(N)
// Space complexity - O(N)