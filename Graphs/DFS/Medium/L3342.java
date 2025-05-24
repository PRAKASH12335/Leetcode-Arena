package Graphs.DFS.Medium;

// 3342. Find Minimum Time to Reach Last Room II

import java.util.Arrays;
import java.util.PriorityQueue;

class NodeT {
    int x;
    int y;
    int time;
    boolean toggle;

    public NodeT(int x, int y, int time, boolean toggle) {
        this.x = x;
        this.y = y;
        this.time = time;
        this.toggle = toggle;
    }
}

public class L3342 {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length, n = moveTime[0].length;
        int[][] dis = new int[m][n];
        Arrays.stream(dis).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));
        dis[0][0] = 0;
        boolean[][] vis = new boolean[m][n];
        PriorityQueue<NodeT> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.add(new NodeT(0, 0, 0, false));

        int[] dirX = {0, 0, 1, -1};
        int[] dirY = {1, -1, 0, 0};
        while (!pq.isEmpty()) {
            NodeT node = pq.poll();
            int x = node.x;
            int y = node.y;
            int time = node.time;
            boolean toggle = node.toggle;
            if (vis[x][y] == true)
                continue;
            vis[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dirX[i];
                int ny = y + dirY[i];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && vis[nx][ny] == false) {
                    int toggleTime = toggle == false ? 1 : 2;
                    int t = Math.max(dis[x][y], moveTime[nx][ny]) + toggleTime;
                    if (dis[nx][ny] > t) {
                        dis[nx][ny] = t;
                        pq.add(new NodeT(nx, ny, t, !toggle));
                    }
                }
            }
        }
        return dis[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] moveTime = {{0, 4}, {4, 4}};
        System.out.println(new L3342().minTimeToReach(moveTime));
    }
}

// Time Complexity - O(4*M*N * log(M*N))
// Space Complexity - O(M*N)