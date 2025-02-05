package TwoPointers.Medium;

// 3. Longest Substring Without Repeating Characters

import java.util.HashSet;

public class L3 {

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int i = 0, j = 0, n = s.length();
        int ans = 0;
        while (j < n) {
            char c = s.charAt(j);
            if (!set.contains(c)) {
                set.add(c);
                j++;
                ans = Math.max(ans, j - i);
            } else if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new L3().lengthOfLongestSubstring(s));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)