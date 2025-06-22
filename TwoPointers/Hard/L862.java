package TwoPointers.Hard;

// 862. Shortest Subarray with Sum at Least K

import java.util.Deque;
import java.util.LinkedList;

public class L862 {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] += prefixSum[i - 1] + nums[i - 1];
        }
        int minLength = Integer.MAX_VALUE;
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i <= n; i++) {
            while (!dq.isEmpty() && prefixSum[i] - prefixSum[dq.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - dq.pollFirst());
            }
            while (!dq.isEmpty() && prefixSum[i] <= prefixSum[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {84, -37, 37, 40, 95};
        int k = 167;
        System.out.println(new L862().shortestSubarray(nums, k));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)