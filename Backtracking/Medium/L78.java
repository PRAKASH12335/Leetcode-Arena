package Backtracking.Medium;

// 78. Subsets

import java.util.ArrayList;
import java.util.List;

public class L78 {

    private void helper(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {
        ans.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(ans, nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, nums, new ArrayList<>(), 0);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new L78().subsets(nums));
    }
}

// Time Complexity - O(2^N)
// Space Complexity - O(N)