package Interval.Medium;

// 1094. Car Pooling

import java.util.Arrays;

public class L1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int max = 0;
        for (int[] trip : trips) {
            max = Math.max(max, trip[2]);
        }
        int[] arr = new int[max + 1];
        for (int[] trip : trips) {
            arr[trip[1]] += trip[0];
            arr[trip[2]] -= trip[0];
        }
        for (int i = 0; i < arr.length; i++) {
            capacity -= arr[i];
            if (capacity < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 4;
        System.out.println(new L1094().carPooling(trips, capacity));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)