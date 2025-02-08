package Backtracking.Medium;

// 47. Permutations II

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L47 {

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void helper(int[] nums, List<List<Integer>> ans, Set<List<Integer>> set, int index) {
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }
            if (!set.contains(temp)) {
                set.add(temp);
                ans.add(temp);
            }
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            helper(nums, ans, set, index + 1);
            swap(nums, i, index);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        helper(nums, ans, set, 0);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(new L47().permuteUnique(nums));
    }
}

// Time Complexity - O(N * N!)
// Space Complexity - O(1)