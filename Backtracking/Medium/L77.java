package Backtracking.Medium;

// 77. Combinations

import java.util.ArrayList;
import java.util.List;

public class L77 {

    private void helper(List<List<Integer>> ans, int n, int k, List<Integer> temp, int num) {
        if (k == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = num; i <= n; i++) {
            temp.add(i);
            helper(ans, n, k - 1, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, n, k, new ArrayList<>(), 1);
        return ans;
    }

    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(new L77().combine(n, k));
    }
}

// Time Complexity - O(2^N)
// Space Complexity - O(N)