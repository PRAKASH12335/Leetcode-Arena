package String.Easy;

// 14. Longest Common Prefix

import java.util.Arrays;

public class L14 {

    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0) return "";
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            if (strs[0].charAt(i) != strs[n - 1].charAt(i)) {
                return sb.toString();
            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(new L14().longestCommonPrefix(strs));
    }
}

// Time Complexity - O(N * logN)
// Space Complexity - O(1)