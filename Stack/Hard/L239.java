package Stack.Hard;

// 239. Sliding Window Maximum

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class L239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();
            dq.addLast(i);
        }
        ans[0] = nums[dq.peekFirst()];
        for (int i = k; i < n; i++) {
            while (!dq.isEmpty() && i - dq.peekFirst() >= k)
                dq.pollFirst();
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();
            dq.addLast(i);
            ans[i - k + 1] = nums[dq.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ans = new L239().maxSlidingWindow(nums, k);
        Arrays.stream(ans).forEach(a -> System.out.print(a + " "));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)