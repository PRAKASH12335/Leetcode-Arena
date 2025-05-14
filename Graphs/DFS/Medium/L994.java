package Graphs.DFS.Medium;

// 994. Rotting Oranges

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int x;
    int y;
    int time;

    public Node(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class L994 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int cnt = 0;
        boolean[][] vis = new boolean[m][n];
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Node(i, j, 0));
                    vis[i][j] = true;
                }
                if (grid[i][j] == 1) {
                    cnt++;
                }
            }
        }

        int count = 0;
        int maxTime = 0;
        int[] dirX = {0, 0, 1, -1};
        int[] dirY = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            Node nd = q.poll();
            int x = nd.x;
            int y = nd.y;
            int time = nd.time;
            for (int i = 0; i < 4; i++) {
                int nx = x + dirX[i];
                int ny = y + dirY[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && vis[nx][ny] == false && grid[nx][ny] == 1) {
                    vis[nx][ny] = true;
                    q.add(new Node(nx, ny, time + 1));
                    grid[nx][ny] = 2;
                    maxTime = time + 1;
                    count++;
                }
            }
        }
        return cnt == count ? maxTime : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(new L994().orangesRotting(grid));
    }
}

// Time Complexity - O(M*N)
// Space Complexity - O(M*N)