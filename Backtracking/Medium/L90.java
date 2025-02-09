package Backtracking.Medium;

// 90. Subsets II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L90 {
    private void helper(int[] nums, List<List<Integer>> ans, List<Integer> list, int index) {
        ans.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;
            list.add(nums[i]);
            helper(nums, ans, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(new L90().subsetsWithDup(nums));
    }
}

// Time Complexity - O(2^N)
// Space Complexity - O(N)