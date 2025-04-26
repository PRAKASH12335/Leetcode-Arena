package BinarySearch.Medium;

// 1482. Minimum Number of Days to Make m Bouquets

import java.util.Arrays;

public class L1482 {
    private boolean possibleDays(int[] bloomDay, int mid, int m, int k) {
        int totalBouquets = 0;
        int window = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= mid) {
                window++;
            } else {
                totalBouquets += (window / k);
                window = 0;
            }
        }
        totalBouquets += (window / k);
        return totalBouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) m * k > n) return -1;

        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();
        while (low <= high) {
            int mid = (low + high) / 2;
            if (possibleDays(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] bloomDay = {1, 10, 3, 10, 2};
        int m = 3, k = 1;
        System.out.println(new L1482().minDays(bloomDay, m, k));
    }
}

// Time Complexity - O(N * log(max(bloomDay)))
// Space Complexity - O(1)