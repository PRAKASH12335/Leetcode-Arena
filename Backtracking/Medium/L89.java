package Backtracking.Medium;

// 89. Gray Code

import java.util.ArrayList;
import java.util.List;

public class L89 {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        if (n == 0) {
            ans.add(0);
            return ans;
        }
        if (n == 1) {
            ans.add(0);
            ans.add(1);
            return ans;
        }
        for (int i = 0; i < Math.pow(2, n); i++) {
            ans.add(i ^ (i >> 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(new L89().grayCode(n));
    }
}

// Time Complexity - O(2^N)
// Space Complexity - O(1)