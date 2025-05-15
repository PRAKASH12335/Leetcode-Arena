package Graphs.DFS.Medium;

// 207. Course Schedule

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int[] p : prerequisites) {
            adjList.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            cnt++;
            for (int it : adjList.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return cnt == numCourses;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        System.out.println(new L207().canFinish(numCourses, prerequisites));
    }
}

// Time Complexity: O(N+E)
//Space complexity: O(N)+O(N)