package Arrays.Easy;

// 2389. Longest Subsequence With Limited Sum

import java.util.Arrays;

public class L2389 {
    public int binarySearch(int[] nums, int q) {
        int l = 0, h = nums.length - 1;
        int resultIndex = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] <= q) {
                resultIndex = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return resultIndex + 1;
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        Arrays.stream(nums).forEach(a -> System.out.print(a + " "));
        int i = 0;
        int[] result = new int[queries.length];
        for (int q : queries) {
            int count = binarySearch(nums, q);
            result[i++] = count;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 2, 1}, queries = {3, 10, 21};
        int[] ans = new L2389().answerQueries(nums, queries);
        Arrays.stream(ans).forEach(a -> System.out.print(a + " "));
    }
}

// Time Complexity - O(N*logN + N + M*logN) ~ O((M + N) * logN)
// Space Complexity - O(1)