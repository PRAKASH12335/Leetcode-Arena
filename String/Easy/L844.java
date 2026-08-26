package String.Easy;

// 844. Backspace String Compare

import java.util.Stack;

public class L844 {
    private String build(String s){
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c != '#'){
                st.push(c);
            }else if(!st.isEmpty()){
                st.pop();
            }
        }
        return String.valueOf(st);
    }
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
    public static void main(String[] args) {
        String s = "ab##", t = "c#d#";
        System.out.println(new L844().backspaceCompare(s, t));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)