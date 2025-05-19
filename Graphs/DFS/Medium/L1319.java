package Graphs.DFS.Medium;

// 1319. Number of Operations to Make Network Connected

public class L1319 {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;
        for (int[] con : connections) {
            if (ds.findParent(con[0]) != ds.findParent(con[1]))
                ds.unionBySize(con[0], con[1]);
            else
                extraEdges++;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent.get(i) == i) {
                ans++;
            }
        }
        return extraEdges >= ans - 1 ? ans - 1 : -1;
    }

    public static void main(String[] args) {
        int V = 9;
        int[][] edge = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {2, 3}, {4, 5}, {5, 6}, {7, 8}};
        L1319 obj = new L1319();
        int ans = obj.makeConnected(V, edge);
        System.out.println("The number of operations needed: " + ans);
    }
}

// Time Complexity - O(E*4α)+O(N*4α)
// Space Complexity: O(2N)