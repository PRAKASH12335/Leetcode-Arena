package DynamicProgramming.Medium;

// 518. Coin Change II

import java.util.Arrays;

public class L518 {
    // Recursion
    private int changeRecHelper(int index, int amount, int[] coins) {
        if (index == 0) {
            return amount % coins[0] == 0 ? 1 : 0;
        }
        int notTake = changeRecHelper(index - 1, amount, coins);
        int take = 0;
        if (amount >= coins[index])
            take = changeRecHelper(index, amount - coins[index], coins);
        return notTake + take;
    }

    public int changeRec(int amount, int[] coins) {
        int n = coins.length;
        return changeRecHelper(n - 1, amount, coins);
    }
    // Time Complexity: O(2^N)
    // Space Complexity: O(N)

    // Mmemoization
    private int memoHelper(int index, int amount, int[] coins, int[][] memo) {
        if (index == 0) {
            return amount % coins[0] == 0 ? 1 : 0;
        }
        if (memo[index][amount] != -1) return memo[index][amount];
        int notTake = memoHelper(index - 1, amount, coins, memo);
        int take = 0;
        if (amount >= coins[index])
            take = memoHelper(index, amount - coins[index], coins, memo);
        return memo[index][amount] = notTake + take;
    }
    // Time Complexity: O(N*T)
    // Space Complexity: O(N*T) + O(N)

    public int changeMemo(int amount, int[] coins) {
        int n = coins.length;
        int[][] memo = new int[n][amount + 1];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a, -1));
        return memoHelper(n - 1, amount, coins, memo);
    }

    // DP
    public int changeDP(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) dp[0][i] = 1;
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                int notTake = dp[i - 1][j];
                int take = 0;
                if (j >= coins[i])
                    take = dp[i][j - coins[i]];
                dp[i][j] = notTake + take;
            }
        }
        return dp[n - 1][amount];
    }
    // Time Complexity: O(N*T)
    // Space Complexity: O(N*T)

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        L518 obj = new L518();
        System.out.println(obj.changeRec(amount, coins));
        System.out.println(obj.changeMemo(amount, coins));
        System.out.println(obj.changeDP(amount, coins));
    }
}
