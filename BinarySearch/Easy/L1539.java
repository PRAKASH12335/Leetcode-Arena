package BinarySearch.Easy;

// 1539. Kth Missing Positive Number

public class L1539 {
    public int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = arr[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // arr[high] + more is the answer
        // more = k - missing
        // missing = arr[high] - (high + 1)
        // arr[high] + k - (arr[high] - high - 1)
        // k + high + 1 or low + k as low = high +1
        return k + high + 1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        System.out.println(new L1539().findKthPositive(arr, k));
    }
}

// Time Complexity - O(log N)
// Space Complexity - O(1)