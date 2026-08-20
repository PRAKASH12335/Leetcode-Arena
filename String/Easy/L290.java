package String.Easy;

// 290. Word Pattern

import java.util.HashMap;
import java.util.HashSet;

public class L290 {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length) return false;
        HashSet<String> unique = new HashSet<>();
        HashMap<Character, String> map = new HashMap<>();
        int i = 0, n = pattern.length();
        while (i < n) {
            char ch = pattern.charAt(i);
            String str = strs[i];
            if (!map.containsKey(ch)) {
                if (unique.contains(str))
                    return false;
                map.put(ch, str);
                unique.add(str);
            } else {
                String cmp = map.get(ch);
                if (!cmp.equals(str))
                    return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat fish";
        System.out.println(new L290().wordPattern(pattern, s));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)