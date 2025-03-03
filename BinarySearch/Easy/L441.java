package BinarySearch.Easy;

// 441. Arranging Coins

public class L441 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(new L441().arrangeCoins(n));
    }

    public int arrangeCoins(int n) {
        int ans = 0, sum = n;
        while (sum >= 0) {
            ans++;
            sum = sum - ans;
        }
        return ans - 1;
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)