package Greedy.Easy;

// 409. Longest Palindrome

import java.util.HashMap;

public class L409 {
    public int longestPalindrome(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int odd = 0;
        for (int val : map.values()) {
            if (val % 2 != 0) {
                odd++;
            }
        }
        return odd > 0 ? n - odd + 1 : n;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(new L409().longestPalindrome(s));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)