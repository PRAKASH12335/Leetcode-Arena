package String.Medium;

// 443. String Compression

import java.util.ArrayList;
import java.util.List;

public class L443 {

    public int compress(char[] chars) {
        int count = 1, n = chars.length;
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            if (chars[i] == chars[i + 1]) {
                count++;
            } else {
                list.add(chars[i]);
                if (count > 1) {
                    for (char c : String.valueOf(count).toCharArray()) {
                        list.add(c);
                    }
                }
                count = 1;
            }
        }
        list.add(chars[n - 1]);
        if (count > 1) {
            for (char c : String.valueOf(count).toCharArray()) {
                list.add(c);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            chars[i] = list.get(i);
        }
        return list.size();
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(new L443().compress(chars));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)