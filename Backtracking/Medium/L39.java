package Backtracking.Medium;

// 39. Combination Sum

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L39 {
    private void helper(int[] candidates, int target, List<List<Integer>> ans, List<Integer> list, int index) {
        if (target < 0) return;
        if (target == 0) {
            ans.add(new ArrayList<>(list));
        } else {
            for (int i = index; i < candidates.length; i++) {
                list.add(candidates[i]);
                helper(candidates, target - candidates[i], ans, list, i);
                list.remove(list.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates.length == 0)
            return ans;
        Arrays.sort(candidates);
        helper(candidates, target, ans, new ArrayList<Integer>(), 0);
        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(new L39().combinationSum(candidates, target));
    }
}

// Time Complexity - O(N * 2^N)
// Space Complexity - O(N)