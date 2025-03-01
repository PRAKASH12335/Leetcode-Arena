package Interval.Medium;

// 452. Minimum Number of Arrows to Burst Balloons

import java.util.Arrays;

public class L452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int end = points[0][1], count = 1;
        for (int i = 1; i < points.length; i++) {
            if (end < points[i][0]) {
                count++;
                end = Math.max(end, points[i][1]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(new L452().findMinArrowShots(points));
    }
}

// Time Complexity - O(N * logN)
// Space Complexity - O(1)