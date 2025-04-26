package BinarySearch.Medium;

// 875. Koko Eating Bananas

import java.util.Arrays;

public class L875 {
    private boolean checkPossible(int[] piles, int mid, int h) {
        int countHours = 0;
        for (int i = 0; i < piles.length; i++) {
            countHours += Math.ceil((double) piles[i] / mid);
            if (countHours > h)
                return false;
        }
        return countHours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Arrays.stream(piles).max().getAsInt();
        while (low <= high) {
            int mid = (low + high) / 2;
            if (checkPossible(piles, mid, h)) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(new L875().minEatingSpeed(piles, h));
    }
}

// Time Complexity - O(N * log(max))
// Space Complexity - O(1)