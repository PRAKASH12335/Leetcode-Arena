package BinarySearch.Easy;

// 69. Sqrt(x)

public class L69 {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int low = 1, high = x / 2;
        if (low > high)
            return 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid == x / mid)
                return mid;
            if (mid > x / mid)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return high;
    }

    // low = 1, high = 8, mid = 4
    // low = 1, high = 3, mid = 2
    // low = 3, high = 3, mid = 3
    // low = 3, high = 2

    public static void main(String[] args) {
        int x = 4;
        System.out.println(new L69().mySqrt(x));
    }
}

// Time Complexity - O(log N)
// Space Complexity - O(1)