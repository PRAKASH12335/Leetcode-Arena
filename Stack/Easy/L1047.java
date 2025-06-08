package Stack.Easy;

// 1047. Remove All Adjacent Duplicates In String

import java.util.Stack;

public class L1047 {
    public String removeDuplicates(String s) {
        if (s.length() == 0) return "";
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!st.isEmpty() && c == st.peek()) {
                st.pop();
            } else
                st.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(new L1047().removeDuplicates(s));
    }
}

// Time Complexity - O(N))
// Space Complexity - O(N)