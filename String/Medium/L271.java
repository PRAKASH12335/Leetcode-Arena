package String.Medium;

// 271. Encode and Decode Strings

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L271 {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            int size = strs.get(i).length();
            sb.append(size).append(strs.get(i));
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> ans = new ArrayList<>();
        int index = 0;
        while (index < s.length()) {
            int size = Integer.valueOf(String.valueOf(s.charAt(index++)));
            String temp = s.substring(index, index + size);
            ans.add(temp);
            index += size;
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> strs = Arrays.asList("hello", "world", "leetcode", "example");
        L271 obj = new L271();
        String encoded = obj.encode(strs);
        System.out.println(encoded);
        System.out.println(obj.decode(encoded));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)