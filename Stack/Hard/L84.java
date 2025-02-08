package Stack.Hard;

// 84. Largest Rectangle in Histogram

import java.util.Stack;

public class L84 {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int i = 0, top = 0, area = 0, maxArea = 0;
        Stack<Integer> st = new Stack<>();
        while (i < n) {
            if (st.isEmpty() || heights[st.peek()] <= heights[i]) {
                st.push(i++);
            } else {
                top = st.pop();
                if (st.isEmpty())
                    area = heights[top] * i;
                else
                    area = heights[top] * (i - st.peek() - 1);
                maxArea = Math.max(maxArea, area);
            }
        }
        while (!st.isEmpty()) {
            top = st.pop();
            if (st.isEmpty())
                area = heights[top] * i;
            else
                area = heights[top] * (i - st.peek() - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(new L84().largestRectangleArea(heights));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)