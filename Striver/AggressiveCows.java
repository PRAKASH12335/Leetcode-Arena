package Striver;

// Aggressive Cows

import java.util.Arrays;

public class AggressiveCows {
    private boolean canWePlace(int[] stalls, int mid, int k) {
        int cnt = 1, last = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= mid) {
                cnt++;
                last = stalls[i];
            }
        }
        return cnt >= k;
    }

    private int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int res = 0;
        int low = 1, high = stalls[stalls.length - 1] - stalls[0];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canWePlace(stalls, mid, k)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9};
        int k = 3;
        System.out.println(new AggressiveCows().aggressiveCows(stalls, k));
    }
}

// Time Complexity - O(N * log(stalls[n-1)-stalls[0)) + O(N * logN)
// Space Complexity - O(1)