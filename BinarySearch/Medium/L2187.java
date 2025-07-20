package BinarySearch.Medium;

// 2187. Minimum Time to Complete Trips

import java.util.Arrays;

public class L2187 {
    public long getTotalTrips(int[] time, long mid) {
        long trips = 0;
        for (int t : time) {
            trips += mid / t;
        }
        return trips;
    }

    public long minimumTime(int[] time, int totalTrips) {
        long low = Arrays.stream(time).min().getAsInt();
        long high = (long) Arrays.stream(time).max().getAsInt() * totalTrips;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (getTotalTrips(time, mid) >= totalTrips) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return low;
    }


    public static void main(String[] args) {
        int[] time = {1, 2, 3};
        int totalTrips = 5;
        System.out.println(new L2187().minimumTime(time, totalTrips));
    }
}

// Time Complexity - O(M * log(N))
// Space Complexity - O(1)