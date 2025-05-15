package Graphs.DFS.Medium;

// 542. 01 Matrix

import java.util.LinkedList;
import java.util.Queue;

class NodeM {
    int x;
    int y;
    int cost;

    NodeM(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}

public class L542 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dist = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        Queue<NodeM> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new NodeM(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        int[] dirX = {0, 0, 1, -1};
        int[] dirY = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            NodeM node = q.poll();
            int x = node.x;
            int y = node.y;
            int dis = node.cost;
            dist[x][y] = dis;
            for (int i = 0; i < 4; i++) {
                int nx = x + dirX[i];
                int ny = y + dirY[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && vis[nx][ny] == false) {
                    q.add(new NodeM(nx, ny, dis + 1));
                    vis[nx][ny] = true;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] ans = new L542().updateMatrix(mat);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Time Complexity - O(M*N)
// Space Complexity - O(M*N)