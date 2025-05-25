package Graphs.DFS.Medium;

// 684. Redundant Connection

import java.util.Arrays;

public class L684 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n);
        int[] ans = new int[2];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (ds.findParent(u) == ds.findParent(v)) {
                ans[0] = u;
                ans[1] = v;
            } else {
                ds.unionBySize(u, v);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[] ans = new L684().findRedundantConnection(edges);
        Arrays.stream(ans).forEach(a -> System.out.println(a));
    }
}

// Time Complexity: O(N)
// Space Complexity: O(N)