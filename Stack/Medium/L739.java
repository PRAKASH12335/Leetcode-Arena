package Stack.Medium;

// 739. Daily Temperatures

import java.util.Arrays;
import java.util.Stack;

public class L739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i])
                st.pop();
            if(st.isEmpty())
                ans[i] = 0;
            else
                ans[i] = st.peek()-i;
            st.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        L739 obj = new L739();
        int[] ans = obj.dailyTemperatures(temperatures);
        Arrays.stream(ans).forEach(a -> System.out.print(a + " "));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)