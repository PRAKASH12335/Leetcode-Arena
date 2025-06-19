package Graphs.DFS.Hard;

// 1345. Jump Game IV

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class L1345 {
    // BFS
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return 0;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.add(0);
        vis[0] = true;
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int curr = q.poll();
                int left = curr - 1;
                int right = curr + 1;
                if (curr == n - 1)
                    return steps;
                vis[curr] = true;
                if (left >= 0 && vis[left] == false) {
                    q.add(left);
                    vis[left] = true;
                }
                if (right < n && vis[right] == false) {
                    q.add(right);
                    vis[right] = true;
                }
                List<Integer> list = map.get(arr[curr]);
                for (int i : list) {
                    if (vis[i] == false) {
                        q.add(i);
                        vis[i] = true;
                    }
                }
                list.clear();
            }
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] arr = {100, -23, -23, 404, 100, 23, 23, 23, 3, 404};
        System.out.println(new L1345().minJumps(arr));
    }
}

// Time Complexity - O(N))
// Space Complexity - O(N)