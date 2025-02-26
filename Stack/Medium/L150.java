package Stack.Medium;

// 150. Evaluate Reverse Polish Notation

import java.util.Stack;

public class L150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if (s.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b / a);
            } else if (s.equals("*")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b * a);
            } else if (s.equals("+")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b + a);
            } else if (s.equals("-")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            } else
                st.push(Integer.parseInt(s));
        }
        return st.peek();
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        System.out.print(new L150().evalRPN(tokens));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)