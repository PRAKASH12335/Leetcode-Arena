package BinarySearch.Easy;

// 1351. Count Negative Numbers in a Sorted Matrix

public class L1351 {
    public int countNegatives(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int row = m - 1, col = 0;
        int cnt = 0;
        while (row >= 0 && col < n) {
            if (grid[row][col] < 0) {
                cnt += n - col;
                row--;
            } else {
                col++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {4, 3, 2, -1},
                {3, 2, 1, -1},
                {1, 1, -1, -2},
                {-1, -1, -2, -3}
        };
        System.out.println(new L1351().countNegatives(grid));
    }
}

// Time Complexity - O(M + N)
// Space Complexity - O(1)