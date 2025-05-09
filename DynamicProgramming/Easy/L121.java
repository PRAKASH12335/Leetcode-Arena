package DynamicProgramming.Easy;

// 121. Best Time to Buy and Sell Stock

public class L121 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new L121().maxProfit(prices));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)