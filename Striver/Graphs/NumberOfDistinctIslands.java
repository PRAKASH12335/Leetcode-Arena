package Striver.Graphs;

// G-16. Number of distinct Islands

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands {
    private String toString(int x, int y) {
        return x + " " + y;
    }

    private void dfs(int row, int col, int m, int n, int[][] grid, boolean[][] vis, List<String> vec, int row0, int col0) {
        vis[row][col] = true;
        vec.add(toString(row - row0, col - col0));
        int[] dirX = {0, 0, 1, -1};
        int[] dirY = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            int nrow = row + dirX[i];
            int ncol = col + dirY[i];
            if (nrow >= 0 && ncol >= 0 && nrow < m && ncol < n && grid[nrow][ncol] == 1 && vis[nrow][ncol] == false) {
                dfs(nrow, ncol, m, n, grid, vis, vec, row0, col0);
            }
        }
    }

    private int numberOfDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Set<List<String>> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && vis[i][j] == false) {
                    List<String> vec = new ArrayList<>();
                    dfs(i, j, m, n, grid, vis, vec, i, j);
                    set.add(vec);
                }
            }
        }
        for (List<String> s : set) {
            System.out.println(s);
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1},
        };
        System.out.println(new NumberOfDistinctIslands().numberOfDistinctIslands(grid));
    }
}

// Time Complexity - O(M*N * log(M*N) + M*N*4) ~ O(M*N)
// Space Complexity - O(M*N)