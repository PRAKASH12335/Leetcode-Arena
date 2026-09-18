package Stack.Medium;

// 735. Asteroid Collision

import java.util.Arrays;
import java.util.Stack;

public class L735 {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(asteroids[i] > 0){
                st.push(asteroids[i]);
            }else{
                while(!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(asteroids[i])){
                    st.pop();
                }
                if(st.isEmpty() || st.peek() < 0){
                    st.push(asteroids[i]);
                }
                if(!st.isEmpty() && st.peek() == Math.abs(asteroids[i])){
                    st.pop();
                }
            }
        }
        int[] ans = new int[st.size()];
        for(int i=st.size()-1;i>=0;i--){
            ans[i] = st.pop();
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] asteroids = {3,5,-6,2,-1,4};
        L735 obj = new L735();
        int[] ans = obj.asteroidCollision(asteroids);
        Arrays.stream(ans).forEach(a -> System.out.print(a + " "));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)