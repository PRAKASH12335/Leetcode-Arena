package Graphs.DFS.Medium;

// 990. Satisfiability of Equality Equations

import java.util.ArrayList;
import java.util.List;

class DSU {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    DSU(int n) {
        for (int i = 0; i < n; i++) {
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
        if (rank.get(ulp_u) > rank.get(ulp_v)) {
            parent.set(ulp_v, ulp_u);
        } else if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else {
            parent.set(ulp_v, ulp_u);
            int rank_u = rank.get(ulp_u);
            rank.set(ulp_u, rank_u + 1);
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
}


public class L990 {
    public boolean equationsPossible(String[] equations) {
        DSU dsu = new DSU(26);

        for (String str : equations) {
            int first = str.charAt(0) - 'a';
            int second = str.charAt(3) - 'a';
            char sign = str.charAt(1);
            if (sign == '=') {
                dsu.unionBySize(first, second);
            }
        }
        for (String str : equations) {
            int first = str.charAt(0) - 'a';
            int second = str.charAt(3) - 'a';
            char sign = str.charAt(1);
            if (sign == '!') {
                int parent1 = dsu.findParent(first);
                int parent2 = dsu.findParent(second);
                if (parent1 == parent2)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] equations = {"a==b", "b!=a"};
        System.out.println(new L990().equationsPossible(equations));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)