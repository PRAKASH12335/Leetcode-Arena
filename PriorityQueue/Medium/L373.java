package PriorityQueue.Medium;

// 373. Find K Pairs with Smallest Sums

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class L373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums1[i] + nums2[j];
                if (pq.size() < k) {
                    pq.add(new int[]{sum, i, j});
                } else if (pq.peek()[0] > sum) {
                    pq.poll();
                    pq.add(new int[]{sum, i, j});
                } else
                    break;
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] val = pq.poll();
            List<Integer> l = Arrays.asList(nums1[val[1]], nums2[val[2]]);
            ans.add(l);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11}, nums2 = {2, 4, 6};
        int k = 3;
        System.out.println(new L373().kSmallestPairs(nums1, nums2, k));
    }
}

// Time complexity - O(M*N * logK)
// Space complexity - O(N)