package Stack.Easy;

// 20. Valid Parentheses

import java.util.HashMap;
import java.util.Stack;

public class L20 {

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.keySet().contains(c)) {
                st.push(c);
            } else if (map.values().contains(c)) {
                if (!st.isEmpty() && c == map.get(st.peek())) {
                    st.pop();
                } else
                    return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(new L20().isValid(s));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)