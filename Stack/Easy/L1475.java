package Stack.Easy;

// 1475. Final Prices With a Special Discount in a Shop

import java.util.Arrays;
import java.util.Stack;

public class L1475 {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();
        int n = prices.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = prices[i];
        }
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && prices[i] <= prices[st.peek()]) {
                int index = st.pop();
                ans[index] = prices[index] - prices[i];
            }
            st.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] prices = {8, 4, 6, 2, 3};
        int[] ans = new L1475().finalPrices(prices);
        Arrays.stream(ans).forEach(a -> System.out.print(a + " "));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)