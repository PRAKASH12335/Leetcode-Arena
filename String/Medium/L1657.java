package String.Medium;

// 1657. Determine if Two Strings Are Close

import java.util.Arrays;

public class L1657 {
    public boolean closeStrings(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        if (m != n) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((count1[i] == 0 && count2[i] == 0) || (count1[i] != 0 && count2[i] != 0))
                continue;
            return false;
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        return Arrays.equals(count1, count2);
    }

    public static void main(String[] args) {
        String word1 = "abc", word2 = "bca";
        System.out.println(new L1657().closeStrings(word1, word2));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)