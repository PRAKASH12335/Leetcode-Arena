package Interval.Medium;

// 56. Merge Intervals

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                ans.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans.add(new int[]{start, end});
        return ans.toArray(new int[ans.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ans = new L56().merge(intervals);
        for (int[] a : ans) {
            Arrays.stream(a).forEach(b -> System.out.print(b + " "));
            System.out.println();
        }
    }
}

// Time Complexity - O(N * logN)
// Space Complexity - O(1)