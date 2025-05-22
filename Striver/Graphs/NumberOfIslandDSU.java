package Striver.Graphs;

// G-51. Number of Islands - II - Online Queries - DSU

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandDSU {
    public List<Integer> numOfIslands(int m, int n, int[][] operators) {
        boolean[][] vis = new boolean[m][n];
        DisjointSet ds = new DisjointSet(m * n);
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();
        int len = operators.length;
        for (int i = 0; i < len; i++) {
            int row = operators[i][0];
            int col = operators[i][1];
            if (vis[row][col] == true) {
                ans.add(cnt);
                continue;
            }
            vis[row][col] = true;
            cnt++;

            int[] dirX = {0, 0, 1, -1};
            int[] dirY = {1, -1, 0, 0};
            for (int j = 0; j < 4; j++) {
                int nrow = dirX[j] + row;
                int ncol = dirY[j] + col;
                if (nrow >= 0 && ncol >= 0 && nrow < m && ncol < n) {
                    if (vis[nrow][ncol] == true) {
                        int nodeNo = row * n + col;
                        int adjNodeNo = nrow * n + ncol;
                        if (ds.findParent(nodeNo) != ds.findParent(adjNodeNo)) {
                            cnt--;
                            ds.unionBySize(nodeNo, adjNodeNo);
                        }
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        int m = 4, n = 5;
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
                {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}
        };
        NumberOfIslandDSU obj = new NumberOfIslandDSU();
        List<Integer> ans = obj.numOfIslands(m, n, operators);

        int sz = ans.size();
        for (int i = 0; i < sz; i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("");
    }
}

// Time Complexity - O(Q*4α) ~ O(Q) where Q = no. of queries. The term 4α is so small that it can be considered constant.
// Space Complexity - O(Q) + O(N*M) + O(N*M), where Q = no. of queries, N = total no. of rows, M = total no. of columns.