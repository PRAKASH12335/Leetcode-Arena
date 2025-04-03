package PriorityQueue.Medium;

// 973. K Closest Points to Origin

import java.util.Arrays;
import java.util.PriorityQueue;

public class L973 {
    private int distance(int[] p) {
        return p[1] * p[1] + p[0] * p[0];
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(distance(b), distance(a)));
        for (int[] p : points) {
            pq.add(p);
            if (pq.size() > k)
                pq.poll();
        }
        int[][] ans = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i++] = pq.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;
        int[][] ans = new L973().kClosest(points, k);
        Arrays.stream(ans).forEach(a -> System.out.println(a[0] + " " + a[1]));
    }
}

// Time Complexity - O(N * logK)
// Space Complexity - O(N)