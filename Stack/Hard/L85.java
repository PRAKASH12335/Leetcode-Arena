package Stack.Hard;

// 85. Maximal Rectangle

import java.util.Stack;

public class L85 {

    private int areaOfHistogram(int[] heights) {
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

    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] height = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0)
                    height[i][j] = matrix[i][j] == '1' ? 1 : 0;
                else
                    height[i][j] = matrix[i][j] == '1' ? height[i - 1][j] + 1 : 0;
            }
        }
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
            maxArea = Math.max(maxArea, areaOfHistogram(height[i]));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        System.out.println(new L85().maximalRectangle(matrix));
    }
}

// Time Complexity - O(M * N)
// Space Complexity - O(M * N)