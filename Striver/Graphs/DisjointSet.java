package Striver.Graphs;

// G-46. Disjoint Set - Union by Rank

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    public int findParent(int u) {
        if (u == parent.get(u))
            return u;
        int ulp_u = findParent(parent.get(u));
        parent.set(u, ulp_u);
        return parent.get(u);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_u) > rank.get(ulp_v)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_u, ulp_v);
            int rankV = rank.get(ulp_v);
            rank.set(ulp_v, rankV + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }

    public static void main(String[] args) {
//        DisjointSet ds = new DisjointSet(7);
//        ds.unionByRank(1, 2);
//        ds.unionByRank(2, 3);
//        ds.unionByRank(4, 5);
//        ds.unionByRank(6, 7);
//        ds.unionByRank(5, 6);
//
//        if(ds.findParent(3) == ds.findParent(7)){
//            System.out.println("Same");
//        }else{
//            System.out.println("Not Same");
//        }
//        ds.unionByRank(3, 7);
//        if(ds.findParent(3) == ds.findParent(7)){
//            System.out.println("Same");
//        }else{
//            System.out.println(" Not Same");
//        }

        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
        ds.unionBySize(3, 7);
        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same");
        } else {
            System.out.println(" Not Same");
        }
    }
}

// Time Complexity: O(4 alpha)
// Space Complexity: O(3N) ~ O(N)