package Graphs.DFS.Medium;

// 841. Keys and Rooms

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;

public class L841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        vis[0] = true;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < rooms.get(0).size(); i++) {
            q.add(rooms.get(0).get(i));
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            if (vis[node] == false) {
                vis[node] = true;
                for (int i = 0; i < rooms.get(node).size(); i++) {
                    q.add(rooms.get(node).get(i));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (vis[i] == false)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1, 3));
        rooms.add(Arrays.asList(3, 0, 1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));
        System.out.println(new L841().canVisitAllRooms(rooms));
    }
}

// Time Complexity - O(N + E)
// Time Complexity - O(N)