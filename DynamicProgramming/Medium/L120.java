package DynamicProgramming.Medium;

// 120. Triangle

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L120 {
    // Recursion
    private int helper(List<List<Integer>> triangle, int i, int row) {
        if (row >= triangle.size() || i >= triangle.get(row).size())
            return 0;
        int choice1 = triangle.get(row).get(i) + helper(triangle, i, row + 1);
        int choice2 = triangle.get(row).get(i) + helper(triangle, i + 1, row + 1);
        return Math.min(choice1, choice2);
    }

    public int minimumTotalRec(List<List<Integer>> triangle) {
        return helper(triangle, 0, 0);
    }
    //  Time Complexity - O(2^(1+2+3... n))

    // Memoization
    private int memoHelper(List<List<Integer>> triangle, int i, int row, int[][] memo) {
        if (row >= triangle.size() || i >= triangle.get(row).size())
            return 0;
        if (memo[row][i] != -1) return memo[row][i];
        int choice1 = triangle.get(row).get(i) + memoHelper(triangle, i, row + 1, memo);
        int choice2 = triangle.get(row).get(i) + memoHelper(triangle, i + 1, row + 1, memo);
        return memo[row][i] = Math.min(choice1, choice2);
    }

    public int minimumTotalMemo(List<List<Integer>> triangle) {
        int[][] memo = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));
        return memoHelper(triangle, 0, 0, memo);
    }
    // Time Complexity - O(n*n)
    // Space Complexity - O(n)

    // DP
    public int minimumTotalDP(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
    // Time Complexity - O(n*n)
    // Space Complexity - O(n)

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        L120 obj = new L120();
        System.out.println(obj.minimumTotalRec(triangle));
        System.out.println(obj.minimumTotalMemo(triangle));
        System.out.println(obj.minimumTotalDP(triangle));
    }
}
