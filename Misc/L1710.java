package Misc;

// 1710. Maximum Units on a Truck

import java.util.Arrays;

public class L1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int ans = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            int numBoxes = boxTypes[i][0];
            int unitBoxes = boxTypes[i][1];
            if (numBoxes < truckSize) {
                ans += numBoxes * unitBoxes;
                truckSize -= numBoxes;
            } else {
                ans += truckSize * unitBoxes;
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] boxTypes = {{1, 3}, {2, 2}, {3, 1}};
        int truckSize = 4;
        System.out.println(new L1710().maximumUnits(boxTypes, truckSize));
    }
}

// Time Complexity - O(N * logN)
// Space Complexity - O(1)