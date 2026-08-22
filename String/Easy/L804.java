package String.Easy;

// 804. Unique Morse Code Words

import java.util.HashSet;

public class L804 {
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> hset = new HashSet<>();
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        for (String w : words) {
            char[] wordArr = w.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char c : wordArr) {
                sb.append(morse[c - 'a']);
            }
            hset.add(sb.toString());
        }
        return hset.size();
    }

    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(new L804().uniqueMorseRepresentations(words));
    }
}

// Time Complexity - O(N)) where N = sum of the lengths of words in word
// Space Complexity - O(N)