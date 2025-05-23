package Interval.Medium;

// 646. Maximum Length of Pair Chain

import java.util.Arrays;

public class L646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int count = 1, end = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (end < pairs[i][0]) {
                count++;
                end = pairs[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println(new L646().findLongestChain(pairs));
    }
}

// Time Complexity - O(N * logN)
// Space Complexity - O(1)