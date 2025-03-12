package TwoPointers.Medium;

// 567. Permutation in String

import java.util.Arrays;

public class L567 {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < m; i++) {
            count1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < m; i++) {
            count2[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(count1, count2)) {
            return true;
        }
        int index = 0;
        for (int i = m; i < n; i++) {
            count2[s2.charAt(i) - 'a']++;
            count2[s2.charAt(index) - 'a']--;
            if (Arrays.equals(count1, count2)) {
                return true;
            }
            index++;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(new L567().checkInclusion(s1, s2));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)