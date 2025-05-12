package Graphs.DFS.Medium;

// 269. Alien Dictionary

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L269 {
    private List<Integer> topoSortBFS(List<List<Integer>> adjList, int n) {
        int[] indegree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int it : adjList.get(i)) {
                indegree[it]++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int temp = q.poll();
            topo.add(temp);
            for (int it : adjList.get(temp)) {
                indegree[it]--;
                if (indegree[it] == 0)
                    q.offer(it);
            }
        }
        return topo;
    }

    private String alienOrder(String[] words, int n, int k) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            for (int j = 0; j < Math.min(s1.length(), s2.length()); j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    adjList.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }
        List<Integer> topo = topoSortBFS(adjList, k);
        String ans = "";
        for (int it : topo) {
            ans += (char) ('a' + it);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5, k = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        L269 obj = new L269();
        System.out.println(obj.alienOrder(dict, n, k));
    }
}

// Time Complexity - O(N*len)+O(K+E)
// where N is the number of words in the dictionary, ‘len’ is the length up to the index where the first inequality occurs
// K = no. of nodes, and E = no. of edges.
// Space Complexity: O(K) + O(K)+O(K)+O(K) ~ O(4K)