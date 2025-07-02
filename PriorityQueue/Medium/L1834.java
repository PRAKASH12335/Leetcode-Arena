package PriorityQueue.Medium;

// 1834. Single-Threaded CPU

import java.util.Arrays;
import java.util.PriorityQueue;

public class L1834 {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] ts = new int[n][3];
        for (int i = 0; i < n; i++) {
            ts[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(ts, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] ans = new int[n];
        int currTime = 0, i = 0, k = 0;
        while (i < n || !pq.isEmpty()) {
            if (pq.isEmpty()) {
                currTime = Math.max(currTime, ts[i][0]);
            }
            while (i < n && ts[i][0] <= currTime) {
                pq.add(new int[]{ts[i][1], ts[i][2]});
                i++;
            }
            int[] p = pq.poll();
            ans[k++] = p[1];
            currTime += p[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] tasks = {{1, 2}, {2, 4}, {3, 2}, {4, 1}};
        int[] ans = new L1834().getOrder(tasks);
        Arrays.stream(ans).forEach(a -> System.out.print(a + " "));
    }
}

// Time Complexity - O(N * logN)
// Space Complexity - O(N)