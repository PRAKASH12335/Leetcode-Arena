package DynamicProgramming.Medium;

// 322. Coin Change

import java.util.Arrays;

public class L322 {
    // Recursion
    private int helper(int[] coins, int amount, int index) {
        if (index == 0) {
            if (amount % coins[0] == 0)
                return amount / coins[0];
            return Integer.MAX_VALUE - 1;
        }
        int notTake = helper(coins, amount, index - 1);
        int take = Integer.MAX_VALUE - 1;
        if (coins[index] <= amount)
            take = 1 + helper(coins, amount - coins[index], index);
        return Math.min(take, notTake);
    }

    public int coinChangeRec(int[] coins, int amount) {
        int ans = helper(coins, amount, coins.length - 1);
        if (ans >= Integer.MAX_VALUE - 1)
            return -1;
        return ans;
    }
    // Time Complexity - O(2^N)
    // Space Complexity - O(N)

    // Memoization
    public int memoHelper(int index, int[] coins, int amount, int[][] dp) {
        if (index == 0) {
            if (amount % coins[0] == 0)
                return amount / coins[0];
            return Integer.MAX_VALUE - 1;
        }
        if (dp[index][amount] != -1) return dp[index][amount];
        int notTake = memoHelper(index - 1, coins, amount, dp);
        int take = Integer.MAX_VALUE - 1;
        if (coins[index] <= amount)
            take = 1 + memoHelper(index, coins, amount - coins[index], dp);
        return dp[index][amount] = Math.min(take, notTake);
    }

    public int coinChangeMemo(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        int ans = memoHelper(coins.length - 1, coins, amount, dp);
        return ans >= Integer.MAX_VALUE - 1 ? -1 : ans;
    }
    // Time Complexity - O(N * target)
    // Space Complexity - O(N * target+1)

    // DP
    public int coinChangeDP(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0)
                dp[0][i] = i / coins[0];
            else
                dp[0][i] = Integer.MAX_VALUE - 1;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                int notTake = dp[i - 1][j];
                int take = Integer.MAX_VALUE - 1;
                if (coins[i] <= j)
                    take = 1 + dp[i][j - coins[i]];
                dp[i][j] = Math.min(take, notTake);
            }
        }
        int ans = dp[coins.length - 1][amount];
        return ans >= Integer.MAX_VALUE - 1 ? -1 : ans;
    }
    // Time Complexity - O(N * target+1)
    // Space Complexity - O(N * target+1)

    public static void main(String[] args) {
        int amount = 27;
        int[] coins = {2, 5, 10, 1};
        L322 obj = new L322();
        System.out.println(obj.coinChangeRec(coins, amount));
        System.out.println(obj.coinChangeMemo(coins, amount));
    }
}
