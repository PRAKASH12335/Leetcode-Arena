package Stack.Medium;

// 402. Remove K Digits

import java.util.Stack;

public class L402 {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k == n) return "0";
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && k > 0 && st.peek() - '0' > num.charAt(i) - '0') {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while (k > 0) {
            st.pop();
            k--;
        }
        if (st.isEmpty()) return "0";
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        ans.reverse();
        while (ans.length() > 0 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }
        return ans.toString().equals("") ? "0" : ans.toString();
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(new L402().removeKdigits(num, k));
    }
}

// Time Complexity - O(3N + O(K)) ~O(N)
// Space Complexity - O(2N) ~ O(N)