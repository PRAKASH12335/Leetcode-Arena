package Interval.Medium;

// 253. Meeting Rooms II

import java.util.*;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class L253 {
    // using heap
    public int scheduleMeetingHeap(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1)
            return intervals.length;
        List<Interval> intervalList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(intervalList, (a, b) -> a.start - b.start);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervalList.get(0).end);
        int count = 1;
        for (int i = 1; i < intervalList.size(); i++) {
            if (intervalList.get(i).start < pq.peek()) {
                count++;
            } else {
                pq.poll();
            }
            pq.add(intervalList.get(i).end);
        }
        return count;
    }
    // Time Complexity - O(N * logN)
    // Space Complexity - O(N)

    public int scheduleMeeting(int[][] intervals) {
        int n = intervals.length;
        if (n == 0 || n == 1)
            return n;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 1, j = 0, count = 1, maxCount = 1;
        while (i < n && j < n) {
            if (start[i] < end[j]) {
                i++;
                count++;
            } else {
                j++;
                count--;
            }
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }
    // Time Complexity - O(N * logN)
    // Space Complexity - O(1)

    public static void main(String[] args) {
        int[][] intervals = {{0, 40}, {5, 10}, {15, 20}};
        System.out.println(new L253().scheduleMeeting(intervals));
        System.out.println(new L253().scheduleMeetingHeap(intervals));
    }
}