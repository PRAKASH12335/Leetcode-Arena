package Graphs.DFS.Hard;

// 721. Accounts Merge

import java.util.*;

class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    DisjointSet(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    public int findparent(int u) {
        if (u == parent.get(u))
            return u;
        int ulp_u = findparent(parent.get(u));
        parent.set(u, ulp_u);
        return parent.get(u);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findparent(u);
        int ulp_v = findparent(v);
        if (ulp_u == ulp_v) return;
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_u) > rank.get(ulp_v)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int ulp_u = findparent(u);
        int ulp_v = findparent(v);
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

public class L721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String s = accounts.get(i).get(j);
                if (!map.containsKey(s)) {
                    map.put(s, i);
                } else {
                    ds.unionBySize(i, map.get(s));
                }
            }
        }
        List<String>[] mergedMails = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mergedMails[i] = new ArrayList<>();
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int node = ds.findparent(entry.getValue());
            mergedMails[node].add(key);
        }

        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedMails[i].size() == 0) continue;
            Collections.sort(mergedMails[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for (String it : mergedMails[i]) {
                temp.add(it);
            }
            ans.add(temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "j1@com", "j2@com", "j3@com"));
        accounts.add(Arrays.asList("John", "j4@com"));
        accounts.add(Arrays.asList("Raj", "r1@com", "r2@com"));
        accounts.add(Arrays.asList("John", "j1@com", "j5@com"));
        accounts.add(Arrays.asList("Raj", "r2@com", "r3@com"));
        accounts.add(Arrays.asList("Mary", "m1@com"));

        L721 obj = new L721();
        List<List<String>> ans = obj.accountsMerge(accounts);

        int n = ans.size();
        for (int i = 0; i < n; i++) {
            System.out.print(ans.get(i).get(0) + ": ");
            int size = ans.get(i).size();
            for (int j = 1; j < size; j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }

            System.out.println("");
        }
    }
}

// Time Complexity - O(N+E) + O(E*4ɑ) + O(N*(ElogE + E))
// Space Complexity - O(N)+ O(N) +O(2N) ~ O(N)