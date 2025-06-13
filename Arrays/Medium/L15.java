package Arrays.Medium;

// 15. 3Sum

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (n < 3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            int k = n - 1;
            int target = -(nums[i]);
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    ans.add(Arrays.asList(-target, nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                    while (j < k && nums[k] == nums[k + 1])
                        k--;
                } else if (nums[j] + nums[k] > target)
                    k--;
                else
                    j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new L15().threeSum(nums));
    }
}

// Time Complexity - O(NlogN + N^2) ~ O(N^2)
// Space Complexity - O(1)