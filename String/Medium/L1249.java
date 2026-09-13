package String.Medium;

// 1249. Minimum Remove to Make Valid Parentheses

public class L1249 {
    public String minRemoveToMakeValid(String s) {
        int n = s.length(), open = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                open++;
            else if (ch == ')') {
                if (open == 0)
                    continue;
                open--;
            }
            sb.append(ch);
        }
        StringBuilder ans = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (sb.charAt(i) == '(' && open > 0) {
                open--;
                continue;
            }
            ans.append(sb.charAt(i));
        }
        return ans.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(new L1249().minRemoveToMakeValid(s));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)