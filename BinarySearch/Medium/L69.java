package BinarySearch.Medium;

// 69. Sqrt(x)

public class L69 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int low = 1, high = x / 2;
        if (low > high) return 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid == x / mid) return mid;
            if (mid < x / mid) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return high;
    }

    public static void main(String[] args) {
        int x = 8;
        System.out.println(new L69().mySqrt(x));
    }
}

// Time Complexity - O(log N)
// Space Complexity - O(1)