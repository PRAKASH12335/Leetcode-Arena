package PriorityQueue.Medium;

// 347. Top K Frequent Elements

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class L347 {

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> map.get(a) - map.get(b));
        for (int key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k)
                pq.poll();
        }
        int[] ans = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i++] = pq.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] ans = new L347().topKFrequent(nums, k);
        Arrays.stream(ans).forEach(a -> System.out.print(a + " "));
    }
}

// Time complexity - O(N * logK)
// Space complexity - O(N + K)