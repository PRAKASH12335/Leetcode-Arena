package String.Easy;

// 205. Isomorphic Strings

public class L205 {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char s1 = s.charAt(i);
            char s2 = t.charAt(i);
            if (map1[s1] != map2[s2])
                return false;
            map1[s1] = i + 1;
            map2[s2] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println(new L205().isIsomorphic(s, t));
    }
}

// Time Complexity - O(N)
// Time Complexity - O(1)