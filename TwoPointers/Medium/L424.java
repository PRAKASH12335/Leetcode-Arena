package TwoPointers.Medium;

// 424. Longest Repeating Character Replacement

import java.util.HashMap;

public class L424 {

    public int characterReplacement(String s, int k) {
        int left = 0, right = 0, maxLength = 0, maxFreq = 0;
        int n = s.length();
        int[] count = new int[26];
        while (right < n) {
            char c = s.charAt(right);
            count[c - 'A']++;
            maxFreq = Math.max(maxFreq, count[c - 'A']);
            if ((right - left + 1) - maxFreq > k) {
                count[s.charAt(left) - 'A']--;
                maxFreq = 0;
                left++;
            }
            if ((right - left + 1) - maxFreq <= k)
                maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "ABAB";
        int k = 2;
        System.out.println(new L424().characterReplacement(s, k));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)