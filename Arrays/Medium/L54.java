package Arrays.Medium;

// 54. Spiral Matrix

import java.util.ArrayList;
import java.util.List;

public class L54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        int dir = 0;
        List<Integer> spiral = new ArrayList<>();
        while (left <= right && top <= bottom) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    spiral.add(matrix[top][i]);
                }
                top++;
            } else if (dir == 1) {
                for (int i = top; i <= bottom; i++) {
                    spiral.add(matrix[i][right]);
                }
                right--;
            } else if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    spiral.add(matrix[bottom][i]);
                }
                bottom--;
            } else if (dir == 3) {
                for (int i = bottom; i >= top; i--) {
                    spiral.add(matrix[i][left]);
                }
                left++;
            }
            dir = (dir + 1) % 4;
        }
        return spiral;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        System.out.println(new L54().spiralOrder(matrix));
    }
}

// Time Complexity - O(M*N)
// Space Complexity - O(1)