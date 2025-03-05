package HashMap.Easy;

// 387. First Unique Character in a String

import java.util.HashMap;

public class L387 {

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (countMap.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(new L387().firstUniqChar(s));
    }
}

// Time complexity - O(N)
// Space complexity - O(N)