package TwoPointers.Medium;

// 525. Contiguous Array

import java.util.HashMap;

public class L525 {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int length = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(count)) {
                length = Math.max(length, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 1, 1, 0, 0, 0};
        System.out.println(new L525().findMaxLength(nums));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)