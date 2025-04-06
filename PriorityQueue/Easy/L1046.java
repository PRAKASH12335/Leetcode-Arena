package PriorityQueue.Easy;

// 1046. Last Stone Weight

import java.util.Collections;
import java.util.PriorityQueue;

public class L1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : stones) {
            pq.add(s);
        }
        while (pq.size() > 1) {
            int x = pq.poll();
            int y = pq.poll();
            if (x - y != 0)
                pq.add(x - y);
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(new L1046().lastStoneWeight(stones));
    }
}

// Time Complexity - O(N * logN)
// Space Complexity - O(N)