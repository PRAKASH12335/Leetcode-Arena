package Interval.Medium;

// 986. Interval List Intersections

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int m = firstList.length, n = secondList.length;
        if (m == 0 || n == 0) return new int[][]{};
        int i = 0, j = 0;
        int startMax = 0, endMin = 0;
        List<int[]> ans = new ArrayList<>();

        while (i < m && j < n) {
            startMax = Math.max(firstList[i][0], secondList[j][0]);
            endMin = Math.min(firstList[i][1], secondList[j][1]);

            if (startMax <= endMin) {
                ans.add(new int[]{startMax, endMin});
            }
            if (endMin == firstList[i][1]) i++;
            if (endMin == secondList[j][1]) j++;
        }
        return ans.toArray(new int[ans.size()][2]);
    }

    public static void main(String[] args) {
        int[][] firstList = {
                {0, 2}, {5, 10}, {13, 23}, {24, 25}
        }, secondList = {
                {1, 5}, {8, 12}, {15, 24}, {25, 26}
        };
        int[][] ans = new L986().intervalIntersection(firstList, secondList);
        Arrays.stream(ans).forEach(a -> System.out.println("[" + a[0] + ", " + a[1] + "]"));
    }
}

// Time Complexity - O(M + N)
// Space Complexity - O(1)