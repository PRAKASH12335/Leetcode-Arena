package PriorityQueue.Medium;

// 215. Kth Largest Element in an Array

import java.util.PriorityQueue;

public class L215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : nums){
            pq.add(n);
            if(pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(new L215().findKthLargest(nums, k));
    }
}

// Time complexity - O(N * logK)
// Space complexity - O(K)