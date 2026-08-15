package String.Easy;

// 13. Roman to Integer

import java.util.HashMap;

public class L13 {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> hmap = new HashMap<>();
        hmap.put('I', 1);
        hmap.put('V', 5);
        hmap.put('X', 10);
        hmap.put('L', 50);
        hmap.put('C', 100);
        hmap.put('D', 500);
        hmap.put('M', 1000);
        int res = hmap.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (hmap.get(s.charAt(i)) >= hmap.get(s.charAt(i + 1))) {
                res += hmap.get(s.charAt(i));
            } else {
                res -= hmap.get(s.charAt(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(new L13().romanToInt(s));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)