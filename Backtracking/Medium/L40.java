package Backtracking.Medium;

// 40. Combination Sum II

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L40 {
    private void helper(int[] candidates, int target, List<List<Integer>> ans, List<Integer> list, int index) {
        if (target < 0) return;
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            list.add(candidates[i]);
            helper(candidates, target - candidates[i], ans, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates.length < 0)
            return ans;
        Arrays.sort(candidates);
        helper(candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(new L40().combinationSum2(candidates, target));
    }
}

// Time Complexity - O(N * 2^N)
// Space Complexity - O(N)