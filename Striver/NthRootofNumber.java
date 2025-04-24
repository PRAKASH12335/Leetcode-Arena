package Striver;

// Nth Root of a Number using Binary Search

public class NthRootofNumber {
    public int func(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ans * mid;
            if (ans > 2)
                return 2;
        }
        if (ans == m)
            return 1;
        return 0;
    }

    public int NthRoot(int n, int m) {
        int low = 1, high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midN = func(mid, n, m);
            if (midN == 1) return mid;
            if (midN == 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 3, m = 27;
        System.out.println(new NthRootofNumber().NthRoot(n, m));
    }
}

// Time Complexity - O(log N)
// Space Complexity - O(1)