package Backtracking.Medium;

// 22. Generate Parentheses

import java.util.ArrayList;
import java.util.List;

public class L22 {

    private void helper(List<String> ans, int open, int closed, int n, String str) {
        if (open == n && closed == n) {
            ans.add(str);
        }
        if (open < n)
            helper(ans, open + 1, closed, n, str + '(');
        if (closed < open)
            helper(ans, open, closed + 1, n, str + ')');
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(ans, 0, 0, n, new String());
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> ans = new L22().generateParenthesis(n);
        System.out.println(ans);
    }
}

// Time Complexity - O(2^N)
// Space Complexity - O(1)