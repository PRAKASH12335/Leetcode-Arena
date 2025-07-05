package DynamicProgramming.Medium;

// 792. Number of Matching Subsequences

import java.util.HashMap;

public class L792 {
    public boolean isSubsequence(String s, String word) {
        int m = s.length(), n = word.length();
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == word.charAt(j))
                j++;
            i++;
        }
        return j == n;
    }

    public int numMatchingSubseq(String s, String[] words) {
        int cnt = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String word : map.keySet()) {
            cnt += isSubsequence(s, word) == true ? map.get(word) : 0;
        }
        return cnt;
    }

    public static void main(String[] args) {
        String s = "dsahjpjauf";
        String[] words = {"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
        System.out.println(new L792().numMatchingSubseq(s, words));
    }
}

// Time Complexity: O(N + N * (m + n)), N = number of words, m = length of s, n = length of word
// Space Complexity: O(N)