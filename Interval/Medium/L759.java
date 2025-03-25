package Interval.Medium;

// 759. Employee Free Time

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L759 {
    private int[][] employeeFreeTime(int[][] schedule) {
        Arrays.sort(schedule, (a, b) -> a[0] - b[0]);
        int lastEnd = schedule[0][1];
        List<int[]> ans = new ArrayList<>();
        for (int[] time : schedule) {
            int start = time[0], end = time[1];
            if (lastEnd < start) {
                ans.add(new int[]{lastEnd, start});
            }
            lastEnd = Math.max(lastEnd, end);
        }
        return ans.toArray(new int[ans.size()][2]);
    }

    public static void main(String[] args) {
        int[][] schedule = {{1, 3}, {6, 7}, {2, 4}, {2, 5}, {9, 12}};
        int[][] ans = new L759().employeeFreeTime(schedule);
        Arrays.stream(ans).forEach(a -> System.out.println(a[0] + " " + a[1]));
    }
}

// Time Complexity - O(N * logN)
// Space Complexity - O(1)