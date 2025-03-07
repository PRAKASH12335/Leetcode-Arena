package Stack.Medium;

// 394. Decode String

import java.util.Stack;

public class L394 {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> results = new Stack<>();
        String res = "";
        int index = 0;
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + s.charAt(index) - '0';
                    index = index + 1;
                }
                counts.push(count);
            } else if (s.charAt(index) == '[') {
                results.push(res);
                res = "";
                index = index + 1;
            } else if (s.charAt(index) == ']') {
                StringBuilder sb = new StringBuilder(results.pop());
                int count = counts.pop();
                for (int i = 0; i < count; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                index = index + 1;
            } else {
                res += s.charAt(index);
                index = index + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(new L394().decodeString(s));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)