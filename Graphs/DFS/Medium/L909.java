package Graphs.DFS.Medium;

// 909. Snakes and Ladders

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class L909 {
    // BFS
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        Set<Integer> vis = new HashSet<>();
        vis.add(1);

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int index = arr[0];
            if (index == n * n)
                return arr[1];

            for (int i = index + 1; i <= Math.min(index + 6, n * n); i++) {
                int rowFromTop = (i - 1) / n;
                int row = (n - 1) - rowFromTop;
                int colFromTop = (i - 1) % n;
                int col = rowFromTop % 2 == 0 ? colFromTop : (n - 1) - colFromTop;

                int next = board[row][col] != -1 ? board[row][col] : i;
                System.out.println("next :" + next);
                if (vis.contains(next)) continue;
                vis.add(next);
                q.add(new int[]{next, arr[1] + 1});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        System.out.println(new L909().snakesAndLadders(board));
    }
}

// Time Complexity - O(N * N)
// Space Complexity - O(N * N)