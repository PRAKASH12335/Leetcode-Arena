package Stack.Hard;

// 32. Longest Valid Parentheses

import java.util.Stack;

public class L32 {

    public int longestValidParentheses(String s) {
        if (s.length() == 0) return 0;
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(i);
            } else {
                st.pop();
                if (st.isEmpty())
                    st.push(i);
                else
                    longest = Math.max(longest, i - st.peek());
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(new L32().longestValidParentheses(s));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)