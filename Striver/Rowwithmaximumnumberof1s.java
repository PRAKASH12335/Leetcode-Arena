package Striver;

// Row with maximum number of 1s

public class Rowwithmaximumnumberof1s {
    private int lowerBound(int[] row, int n, int x) {
        int low = 0, high = row.length - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (row[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int rowWithMaximumNoof1s(int[][] mat) {
        int cntMax = 0, index = -1;
        int m = mat[0].length;
        for (int i = 0; i < mat.length; i++) {
            int cntOnes = m - lowerBound(mat[i], m, 1);
            if (cntMax < cntOnes) {
                cntMax = cntOnes;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1}};
        System.out.println(new Rowwithmaximumnumberof1s().rowWithMaximumNoof1s(mat));
    }
}

// Time Complexity - O(N * log M)  N = Number of rows, M = Number of columns
// Space Complexity - O(1)