package Misc;

// 342. Power of Four

public class L342 {

    public boolean isPowerOfFour(int n) {
        int i = 1;
        while (i < n) {
            i = i << 2;
        }
        return i == n;
    }

    public static void main(String[] args) {
        int n = 15;
        System.out.print(new L342().isPowerOfFour(n));
    }
}

// Time Complexity - O(logN)
// Space Complexity - O(1)