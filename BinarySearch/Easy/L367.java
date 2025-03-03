package BinarySearch.Easy;

// 367. Valid Perfect Square

public class L367 {
    private int perfectRoot(int num) {
        int low = 1, high = num;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid * mid == num)
                return mid;
            if (mid > num / mid)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    private boolean isPerfectSquare(int num) {
        int x = perfectRoot(num);
        if (x * x == num)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println(new L367().isPerfectSquare(n));
    }
}

// Time Complexity - O(log N)
// Space Complexity - O(1)