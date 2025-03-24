package Interval.Medium;

// 3169. Count Days Without Meetings

import java.util.Arrays;

public class L3169 {
    public int countDays(int days, int[][] meetings) {
        int freeDays = 0, latestEnd = 0;
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        for (int[] meet : meetings) {
            int start = meet[0], end = meet[1];

            if (start > latestEnd + 1) {
                freeDays += start - latestEnd - 1;
            }
            latestEnd = Math.max(latestEnd, end);
        }
        freeDays += days - latestEnd;
        return freeDays;
    }

    public static void main(String[] args) {
        int[][] meetings = {{5, 7}, {1, 3}, {9, 10}};
        int days = 10;
        System.out.println(new L3169().countDays(days, meetings));
    }
}

// Time Complexity - O(N * logN)
// Space Complexity - O(1)