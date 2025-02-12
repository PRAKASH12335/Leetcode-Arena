package Backtracking.Medium;

// 216. Combination Sum III

import java.util.ArrayList;
import java.util.List;

public class L216 {
    private void helper(List<List<Integer>> ans, int start, int k, int n, List<Integer> list){
        if(list.size() == k && n == 0){
            ans.add(new ArrayList<>(list));
        }else {
            for (int i = start; i <= 9; i++) {
                list.add(i);
                helper(ans, i + 1, k, n-i, list);
                list.remove(list.size() - 1);
            }
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, 1, k, n, new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        int k = 3, n = 9;
        System.out.println(new L216().combinationSum3(k, n));
    }
}

// Time Complexity - O(2^N)
// Space Complexity - O(1)