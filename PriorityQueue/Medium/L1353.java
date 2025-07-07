package PriorityQueue.Medium;

// 1353. Maximum Number of Events That Can Be Attended

import java.util.Arrays;
import java.util.PriorityQueue;

public class L1353 {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int currDay = 1, i = 0, n = events.length, count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (i < n || !pq.isEmpty()) {
            if (pq.isEmpty()) {
                currDay = events[i][0];
            }
            while (i < n && currDay == events[i][0]) {
                pq.add(events[i][1]);
                i++;
            }
            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }
            currDay++;
            while (!pq.isEmpty() && currDay > pq.peek()) {
                pq.poll();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] events = {{1, 2}, {2, 3}, {3, 4}, {1, 2}};
        System.out.println(new L1353().maxEvents(events));
    }
}

// Time Complexity - O(N * logN)
// Space Complexity - O(N)