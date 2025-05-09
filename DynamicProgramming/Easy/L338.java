package DynamicProgramming.Easy;

// 338. Counting Bits

import java.util.Arrays;

public class L338 {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = (i & 1) + dp[i / 2];
        }
        return dp;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] ans = new L338().countBits(n);
        Arrays.stream(ans).forEach(a -> System.out.println(a));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)