package Stack.Medium;

// 678. Valid Parenthesis String

import java.util.Stack;

public class L678 {

    private boolean helper(String s, int ind, int cnt, int length){
        if(cnt < 0) return false;
        if(ind == length) return (cnt == 0);
        if(s.charAt(ind) == '('){
            return helper(s, ind+1, cnt+1, length);
        }
        if(s.charAt(ind) == ')'){
            return helper(s, ind+1, cnt-1, length);
        }
        return helper(s, ind+1, cnt+1, length)
                || helper(s, ind+1, cnt-1, length)
                || helper(s, ind+1, cnt, length);
    }

    // Using recursion
    public boolean checkValidStringRecursion(String s) {
        int n = s.length();
        return helper(s, 0, 0, n);
    }

    // Time Complexity - O(3^N)
    // Space Complexity - O(N)

    private boolean helperMemo(String s, int ind, int cnt, int length, Boolean[][] memo){
        if(cnt < 0) return false;
        if(ind == length) return (cnt == 0);
        if(memo[ind][cnt] != null) return memo[ind][cnt];
        if(s.charAt(ind) == '('){
            memo[ind][cnt] = helperMemo(s, ind+1, cnt+1, length, memo);
        }
        if(s.charAt(ind) == ')'){
            memo[ind][cnt] = helperMemo(s, ind+1, cnt-1, length, memo);
        }
        if(s.charAt(ind) == '*') {
            memo[ind][cnt] = helperMemo(s, ind + 1, cnt + 1, length, memo)
                    || helperMemo(s, ind + 1, cnt - 1, length, memo)
                    || helperMemo(s, ind + 1, cnt, length, memo);
        }
        return memo[ind][cnt];
    }

    // Using Memoization
    public boolean checkValidStringMemo(String s) {
        int n = s.length();
        Boolean[][] memo = new Boolean[n][n];
        return helperMemo(s, 0, 0, n, memo);
    }

    // Time Complexity - O(N^2)
    // Space Complexity - O(N^2)


    // Linear Solution
    public boolean checkValidStringLinear(String s) {
        int max = 0, min = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                min = min+1;
                max = max+1;
            }
            if(ch == ')'){
                min = min-1;
                max = max-1;
            }
            if(ch == '*'){
                min = min-1;
                max = max+1;
            }
            if(min < 0) min = 0;
            if(max < 0) return false;
        }
        return min == 0;
    }

    // Time Complexity - O(N)
    // Space Complexity - O(1)

    // Using Stack
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

    // Time Complexity - O(N)
    // Space Complexity - O(N)

    public static void main(String[] args) {
        String s = "(*))";
        L678 obj = new L678();
        System.out.println(obj.checkValidString(s));
        System.out.println(obj.checkValidStringRecursion(s));
        System.out.println(obj.checkValidStringMemo(s));
        System.out.println(obj.checkValidStringLinear(s));
    }
}