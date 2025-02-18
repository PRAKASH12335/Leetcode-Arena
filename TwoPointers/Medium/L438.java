package TwoPointers.Medium;

// 438. Find All Anagrams in a String

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length())
            return new ArrayList<>();
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < p.length(); i++) {
            count1[p.charAt(i) - 'a']++;
            count2[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(count1, count2))
            ans.add(0);

        for (int i = p.length(); i < s.length(); i++) {
            count2[s.charAt(i) - 'a']++;
            count2[s.charAt(i - p.length()) - 'a']--;
            if (Arrays.equals(count1, count2))
                ans.add(i - p.length() + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        System.out.println(new L438().findAnagrams(s, p));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)