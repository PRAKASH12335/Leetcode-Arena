package BinarySearch.Medium;

// 1011. Capacity To Ship Packages Within D Days

import java.util.Arrays;

public class L1011 {
    private boolean checkPossible(int[] weights, int mid, int days) {
        int cntDays = 1, sum = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > mid) return false;
            if (sum + weights[i] <= mid) {
                sum = sum + weights[i];
            } else {
                sum = weights[i];
                cntDays++;
                if (cntDays > days)
                    return false;
            }
        }
        return cntDays <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();
        while (low <= high) {
            int mid = (low + high) / 2;
            if (checkPossible(weights, mid, days)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
        System.out.println(new L1011().shipWithinDays(weights, days));
    }
}

// Time Complexity - O(N * log(sum-max+1))
// Space Complexity - O(1)