package Interval.Medium;

// 252. Meeting Rooms

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L252 {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1)
            return true;
        List<Interval> intervalList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(intervalList, (a, b) -> a.start - b.start);
        int end = intervalList.get(0).end;
        for (int i = 1; i < intervalList.size(); i++) {
            if (intervalList.get(i).start < end)
                return false;
            end = intervalList.get(i).end;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(new L252().canAttendMeetings(intervals));
    }
}

// Time Complexity - O(N * logN)
// Space Complexity - O(1)