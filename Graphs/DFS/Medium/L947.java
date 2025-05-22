package Graphs.DFS.Medium;

// 947. Most Stones Removed with Same Row or Column - DSU

import java.util.HashMap;
import java.util.Map;

public class L947 {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < stones.length; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        HashMap<Integer, Integer> stoneNode = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            stoneNode.put(nodeRow, 1);
            stoneNode.put(nodeCol, 1);
        }
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : stoneNode.entrySet()) {
            if (ds.findParent(entry.getKey()) == entry.getKey()) {
                cnt++;
            }
        }
        return n - cnt;
    }

    public static void main(String[] args) {
        int[][] stones = {
                {0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}
        };
        L947 obj = new L947();
        System.out.println(obj.removeStones(stones));
    }
}

// Time Complexity: O(N), where N = total no. of stones
// Space Complexity: O(2* (max row index + max column index))