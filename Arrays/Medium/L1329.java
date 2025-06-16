package Arrays.Medium;

// 1329. Sort the Matrix Diagonally

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class L1329 {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // 1. Populate the map of Diagonals
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                map.putIfAbsent(key, new PriorityQueue<>());
                map.get(key).add(mat[i][j]);
            }
        }

        // 2. Refill the matrix with sorted diagonals
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                mat[i][j] = map.get(key).poll();
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {11, 25, 66, 1, 69, 7}, {23, 55, 17, 45, 15, 52}, {75, 31, 36, 44, 58, 8}, {22, 27, 33, 25, 68, 4}, {84, 28, 14, 11, 5, 50}
        };
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        int[][] newMat = new L1329().diagonalSort(mat);
        System.out.println("After Sorting :");
        for (int i = 0; i < newMat.length; i++) {
            for (int j = 0; j < newMat[0].length; j++) {
                System.out.print(newMat[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Time Complexity - O(M * N * log N)
// Space Complexity - O(M*N)