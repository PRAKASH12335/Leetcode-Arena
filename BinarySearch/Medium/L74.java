package BinarySearch.Medium;

// 74. Search a 2D Matrix

public class L74 {
    // Brute force approach
    private boolean binarySearch(int[] matrix, int target) {
        int low = 0, high = matrix.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid] == target)
                return true;
            if (matrix[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][n - 1]) {
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }
    // Time Complexity - O(n) + O(log m)
    // Space Complexity - O(1)

    public boolean searchMatrixBS(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target)
                return true;
            if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
    // Time Complexity - O(log m*n)
    // Space Complexity - O(1)

    public static void main(String[] args) {
        int[][] mat = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        //System.out.println(new L74().searchMatrix(mat, target));
        System.out.println(new L74().searchMatrixBS(mat, target));
    }
}
