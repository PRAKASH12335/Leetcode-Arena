package Interval.Medium;

// 57. Insert Interval

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            if (newInterval == null || newInterval[0] > interval[1])
                ans.add(interval);
            else if (newInterval[1] < interval[0]) {
                ans.add(newInterval);
                ans.add(interval);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        if (newInterval != null) {
            ans.add(newInterval);
        }
        return ans.toArray(new int[ans.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] ans = new L57().insert(intervals, newInterval);
        for (int[] a : ans) {
            Arrays.stream(a).forEach(b -> System.out.print(b + " "));
            System.out.println();
        }
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)