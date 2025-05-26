package HashMap.Medium;

// 2131. Longest Palindrome by Concatenating Two Letter Words

import java.util.HashMap;
import java.util.Map;

public class L2131 {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int result = 0;
        for (String w : words) {
            String reversed = new StringBuilder(w).reverse().toString();
            if (map.getOrDefault(reversed, 0) > 0) {
                result += 4;
                map.put(reversed, map.get(reversed) - 1);
            } else {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int count = entry.getValue();
            if (key.charAt(0) == key.charAt(1) && count > 0) {
                result += 2;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"ab", "ty", "yt", "lc", "cl", "ab"};
        System.out.println(new L2131().longestPalindrome(words));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)