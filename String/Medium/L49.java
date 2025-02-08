package String.Medium;

// 49. Group Anagrams

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class L49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedStr = new String(charArr);
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new L49().groupAnagrams(strs));
    }
}

// Time Complexity - O(N * K * logK)
// Space Complexity - O(N)