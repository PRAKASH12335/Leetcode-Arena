package DynamicProgramming.Hard;

// 1547. Minimum Cost to Cut a Stick

import java.util.Arrays;

public class L1547 {
    // Recursion
    public int recursionHelper(int i, int j, int[] newCuts) {
        if (i > j) return 0;
        int ans = Integer.MAX_VALUE;
        for (int index = i; index <= j; index++) {
            int mini = newCuts[j + 1] - newCuts[i - 1] +
                    recursionHelper(i, index - 1, newCuts) +
                    recursionHelper(index + 1, j, newCuts);
            ans = Math.min(mini, ans);
        }
        return ans;
    }

    public int minCostRecursion(int n, int[] cuts) {
        int len = cuts.length;
        int[] newCuts = new int[len + 2];
        newCuts[0] = 0;
        for (int i = 1; i <= len; i++) {
            newCuts[i] = cuts[i - 1];
        }
        newCuts[len + 1] = n;
        Arrays.sort(newCuts);
        return recursionHelper(1, len, newCuts);
    }
    // Time Complexity - O(2^N)
    // Space Complexity - O(N)

    // Memoization
    public int memoHelper(int i, int j, int[] newCuts, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int ans = Integer.MAX_VALUE;
        for (int index = i; index <= j; index++) {
            int mini = newCuts[j + 1] - newCuts[i - 1] +
                    memoHelper(i, index - 1, newCuts, dp) +
                    memoHelper(index + 1, j, newCuts, dp);
            ans = Math.min(mini, ans);
        }
        return dp[i][j] = ans;
    }

    public int minCostMemo(int n, int[] cuts) {
        int len = cuts.length;
        int[] newCuts = new int[len + 2];
        newCuts[0] = 0;
        for (int i = 1; i <= len; i++) {
            newCuts[i] = cuts[i - 1];
        }
        newCuts[len + 1] = n;
        Arrays.sort(newCuts);
        int[][] dp = new int[len + 1][len + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return memoHelper(1, len, newCuts, dp);
    }
    // Time Complexity - O(N^3)
    // Space Complexity - O(N*N)

    // DP
    public int minCostDP(int n, int[] cuts) {
        int len = cuts.length;
        int[] newCuts = new int[len + 2];
        newCuts[0] = 0;
        for (int i = 1; i <= len; i++) {
            newCuts[i] = cuts[i - 1];
        }
        newCuts[len + 1] = n;
        Arrays.sort(newCuts);
        int[][] dp = new int[len + 2][len + 2];
        for (int i = len; i >= 1; i--) {
            for (int j = i; j <= len; j++) {
                if (i > j) continue;
                int ans = Integer.MAX_VALUE;
                for (int index = i; index <= j; index++) {
                    int mini = newCuts[j + 1] - newCuts[i - 1] +
                            dp[i][index - 1] + dp[index + 1][j];
                    ans = Math.min(mini, ans);
                }
                dp[i][j] = ans;
            }
        }
        return dp[1][len];
    }
    // Time Complexity - O(N^3)
    // Space Complexity - O(N*N)

    public static void main(String[] args) {
        int[] cuts = {1, 3, 4, 5};
        int n = 7;
        System.out.println(new L1547().minCostRecursion(n, cuts));
        System.out.println(new L1547().minCostMemo(n, cuts));
        System.out.println(new L1547().minCostDP(n, cuts));
    }
}