package Stack.Medium;

// 678. Valid Parenthesis String

import java.util.Stack;

public class L678 {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> wild = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                open.push(i);
            else if (ch == '*')
                wild.push(i);
            else {
                if (!open.isEmpty())
                    open.pop();
                else if (!wild.isEmpty())
                    wild.pop();
                else
                    return false;
            }
        }

        while (!open.isEmpty() && !wild.isEmpty()) {
            if (open.peek() < wild.peek()) {
                open.pop();
                wild.pop();
            } else
                return false;
        }
        return open.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(*))";
        System.out.println(new L678().checkValidString(s));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)