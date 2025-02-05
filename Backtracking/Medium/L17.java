package Backtracking.Medium;

// 17. Letter Combinations of a Phone Number

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L17 {

    private void helper(List<String> ans, HashMap<Integer, String> map, String digits, StringBuilder sb, int index) {
        if (sb.length() == digits.length()) {
            ans.add(sb.toString());
        } else {
            for (int i = index; i < digits.length(); i++) {
                String mapping = map.get(Integer.valueOf(String.valueOf(digits.charAt(i))));
                for (int j = 0; j < mapping.length(); j++) {
                    sb.append(mapping.charAt(j));
                    helper(ans, map, digits, sb, i + 1);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> ans = new ArrayList<>();
        helper(ans, map, digits, new StringBuilder(), 0);
        return ans;
    }

    public static void main(String[] args) {
        L17 l = new L17();
        String digits = "23";
        List<String> ans = l.letterCombinations(digits);
        System.out.println(ans);
    }
}

// Time Complexity - O(4^N)
// Space Complexity - O(N)