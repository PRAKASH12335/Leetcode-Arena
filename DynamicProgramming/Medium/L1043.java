package DynamicProgramming.Medium;

// 1043. Partition Array for Maximum Sum

import java.util.Arrays;

public class L1043 {
    // Recursion
    public int recursionHelper(int index, int n, int[] arr, int k) {
        if (index == n) return 0;
        int maxi = Integer.MIN_VALUE, maxAns = Integer.MIN_VALUE;
        int len = 0;

        for (int i = index; i < Math.min(index + k, n); i++) {
            len++;
            maxi = Math.max(maxi, arr[i]);
            int sum = maxi * len + recursionHelper(i + 1, n, arr, k);
            maxAns = Math.max(sum, maxAns);
        }
        return maxAns;
    }

    public int maxSumAfterPartitioningRecursion(int[] arr, int k) {
        int n = arr.length;
        return recursionHelper(0, n, arr, k);
    }
    // Time Complexity - O(2 ^ N)
    // Space Complexity - O(N)

    // Memoization
    public int memoHelper(int index, int n, int[] arr, int k, int[] memo) {
        if (index == n) return 0;
        if (memo[index] != -1) return memo[index];
        int maxi = Integer.MIN_VALUE, maxAns = Integer.MIN_VALUE;
        int len = 0;

        for (int i = index; i < Math.min(index + k, n); i++) {
            len++;
            maxi = Math.max(maxi, arr[i]);
            int sum = maxi * len + memoHelper(i + 1, n, arr, k, memo);
            maxAns = Math.max(sum, maxAns);
        }
        return memo[index] = maxAns;
    }

    public int maxSumAfterPartitioningMemo(int[] arr, int k) {
        int n = arr.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return memoHelper(0, n, arr, k, memo);
    }
    // Time Complexity - O(N * K)
    // Space Complexity - O(N)

    // DP
    public int maxSumAfterPartitioningDP(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int maxi = Integer.MIN_VALUE, maxAns = Integer.MIN_VALUE;
            int len = 0;
            for (int j = i; j < Math.min(i + k, n); j++) {
                len++;
                maxi = Math.max(maxi, arr[j]);
                int sum = maxi * len + dp[j + 1];
                maxAns = Math.max(sum, maxAns);
            }
            dp[i] = maxAns;
        }
        return dp[0];
    }
    // Time Complexity - O(N * K)
    // Space Complexity - O(N)

    public static void main(String[] args) {
        int[] arr = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        L1043 obj = new L1043();
        System.out.println(obj.maxSumAfterPartitioningRecursion(arr, k));
        System.out.println(obj.maxSumAfterPartitioningMemo(arr, k));
        System.out.println(obj.maxSumAfterPartitioningDP(arr, k));
    }
}