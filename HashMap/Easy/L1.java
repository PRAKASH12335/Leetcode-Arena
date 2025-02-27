package HashMap.Easy;

// 1. Two Sum

import java.util.Arrays;
import java.util.HashMap;

public class L1 {

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        if (nums.length < 2)
            return new int[]{-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                ans[0] = map.get(temp);
                ans[1] = i;
                return ans;
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ans = new L1().twoSum(nums, target);
        Arrays.stream(ans).forEach(a -> System.out.print(a));
    }
}

// Time complexity - O(N)
// Space complexity - O(N)