package Greedy.Medium;

// 252. Minimum Platforms Required for Given Arrival and Departure Times

import java.util.Arrays;
import java.util.PriorityQueue;

public class L252 {
    public int minPlatformPQ(int[] arr, int[] dep) {
        int n = arr.length;
        int[][] platform = new int[n][2];
        for (int i = 0; i < n; i++) {
            platform[i][0] = arr[i];
            platform[i][1] = dep[i];
        }
        Arrays.sort(platform, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int deptTime = platform[0][1];
        pq.add(deptTime);
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (pq.peek() > platform[i][0]) {
                count++;
            } else {
                pq.poll();
            }
            pq.add(platform[i][1]);
        }
        return count;
    }
    // Time Complexity - O(N * log N)
    // Space Complexity - O(N)

    public int minPlatform(int[] arr, int[] dep) {
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int count = 1, ans = 1;
        int i = 1, j = 0;
        while (i < n && j < n) {
            if (arr[i] < dep[j]) {
                i++;
                count++;
            } else {
                j++;
                count--;
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }
    // Time Complexity - O(N * log N)
    // Space Complexity - O(1)

    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(new L252().minPlatformPQ(arr, dep));
        System.out.println(new L252().minPlatform(arr, dep));
    }
}