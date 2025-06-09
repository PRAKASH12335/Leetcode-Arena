package Stack.Hard;

// 1944. Number of Visible People in a Queue

import java.util.Arrays;
import java.util.Stack;

public class L1944 {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] result = new int[n];
        Stack<int[]> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek()[0] < heights[i]) {
                int index = st.pop()[1];
                result[index]++;
            }
            if (!st.isEmpty()) {
                result[st.peek()[1]]++;
            }
            st.push(new int[]{heights[i], i});
        }
        return result;
    }

    public static void main(String[] args) {
        int[] heights = {10, 6, 8, 5, 11, 9};
        int[] ans = new L1944().canSeePersonsCount(heights);
        Arrays.stream(ans).forEach(a -> System.out.print(a + " "));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)