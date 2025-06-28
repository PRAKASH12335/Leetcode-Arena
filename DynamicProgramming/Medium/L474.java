package DynamicProgramming.Medium;

// 474. Ones and Zeroes

import java.util.Arrays;

public class L474 {
    public int countZeros(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch)
                count++;
        }
        return count;
    }

    // Recursion
    public int recusionHelper(int index, String[] strs, int m, int n, int[] count0, int[] count1) {
        if (index == strs.length)
            return 0;
        if (m < 0 || n < 0)
            return 0;
        int notPick = recusionHelper(index + 1, strs, m, n, count0, count1);
        int cnt0 = m - count0[index];
        int cnt1 = n - count1[index];
        int pick = 0;
        if (cnt0 >= 0 && cnt1 >= 0) {
            pick = 1 + recusionHelper(index + 1, strs, cnt0, cnt1, count0, count1);
        }
        return Math.max(notPick, pick);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[] count0 = new int[strs.length];
        int[] count1 = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            count0[i] = countZeros(strs[i], '0');
            count1[i] = strs[i].length() - count0[i];
        }
        return recusionHelper(0, strs, m, n, count0, count1);
    }
    // Time Complexity - O(Exponential)
    // Space Complexity - O(N)

    // Memoization
    public int recusionHelperMemo(int index, String[] strs, int m, int n, int[] count0, int[] count1, int[][][] arr) {
        if (index == strs.length)
            return 0;
        if (m < 0 || n < 0)
            return 0;
        if (arr[index][m][n] != -1)
            return arr[index][m][n];
        int notPick = recusionHelperMemo(index + 1, strs, m, n, count0, count1, arr);
        int cnt0 = m - count0[index];
        int cnt1 = n - count1[index];
        int pick = 0;
        if (cnt0 >= 0 && cnt1 >= 0) {
            pick = 1 + recusionHelperMemo(index + 1, strs, cnt0, cnt1, count0, count1, arr);
        }
        return arr[index][m][n] = Math.max(notPick, pick);
    }

    public int findMaxFormMemo(String[] strs, int m, int n) {
        int[] count0 = new int[strs.length];
        int[] count1 = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            count0[i] = countZeros(strs[i], '0');
            count1[i] = strs[i].length() - count0[i];
        }
        int[][][] arr = new int[strs.length][m + 1][n + 1];
        Arrays.stream(arr).forEach(a -> Arrays.stream(a).forEach(b -> Arrays.fill(b, -1)));
        return recusionHelperMemo(0, strs, m, n, count0, count1, arr);
    }
    // Time Complexity - O(M * m * n)
    // Space Complexity - O(M * m * n)

    //DP
    public int dp(String[] strs, int m, int n) {
        int M = strs.length;
        int[] count0 = new int[strs.length];
        int[] count1 = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            count0[i] = countZeros(strs[i], '0');
            count1[i] = strs[i].length() - count0[i];
        }
        int[][][] dp = new int[M + 1][m + 1][n + 1];
        for (int i = 0; i < M; i++) {
            dp[M][0][0] = 0;
        }
        for (int i = M - 1; i >= 0; i--) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    int notPick = dp[i + 1][j][k];
                    int cnt0 = j - count0[i];
                    int cnt1 = k - count1[i];
                    int pick = 0;
                    if (cnt0 >= 0 && cnt1 >= 0) {
                        pick = 1 + dp[i + 1][cnt0][cnt1];
                    }
                    dp[i][j][k] = Math.max(notPick, pick);
                }
            }
        }
        return dp[0][m][n];
    }
    // Time Complexity - O(M * m * n)
    // Space Complexity - O(M * m * n)

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        L474 obj = new L474();
        System.out.println(obj.findMaxForm(strs, m, n));
        System.out.println(obj.findMaxFormMemo(strs, m, n));
        System.out.println(obj.dp(strs, m, n));
    }
}