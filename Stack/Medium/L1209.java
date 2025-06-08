package Stack.Medium;

// 1209. Remove All Adjacent Duplicates in String II

import java.util.Stack;

public class L1209 {
    public String removeDuplicates(String s, int k) {
        Stack<Character> st = new Stack<>();
        Stack<Integer> countSt = new Stack<>();

        int n = s.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!st.isEmpty() && c == st.peek()) {
                int cnt = countSt.pop();
                countSt.push(cnt + 1);

            } else if (!st.isEmpty() && c != st.peek()) {
                count = 0;
            }
            if (!countSt.isEmpty() && countSt.peek() == k) {
                st.pop();
                countSt.pop();
            }
            if (count == 0) {
                st.push(c);
                count = 1;
                countSt.push(count);
            }
            if (st.isEmpty()) {
                count = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            int cnt = countSt.pop();
            char c = st.pop();
            for (int i = 0; i < cnt; i++) {
                sb.append(c);
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(new L1209().removeDuplicates(s, k));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)