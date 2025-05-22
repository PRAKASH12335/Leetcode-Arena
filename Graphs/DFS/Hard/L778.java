package Graphs.DFS.Hard;

// 778. Swim in Rising Water

import java.util.PriorityQueue;

class CostNode {
    int x;
    int y;
    int cost;

    public CostNode(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }
}

public class L778 {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        PriorityQueue<CostNode> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new CostNode(0, 0, grid[0][0]));
        int[] dirX = {0, 0, 1, -1};
        int[] dirY = {1, -1, 0, 0};
        while (!pq.isEmpty()) {
            CostNode node = pq.poll();
            int x = node.x;
            int y = node.y;
            int cost = node.cost;
            if (x == n - 1 && y == n - 1)
                return cost;
            if (vis[x][y] == true)
                continue;
            vis[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dirX[i];
                int ny = y + dirY[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && vis[nx][ny] == false) {
                    pq.add(new CostNode(nx, ny, Math.max(grid[nx][ny], cost)));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 2, 3, 4},
                {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16},
                {11, 17, 18, 19, 20},
                {10, 9, 8, 7, 6}
        };
        System.out.println(new L778().swimInWater(grid));
    }
}

// Time Complexity - O(M*N * log(M*N))
// Space Complexity - O(M*N)