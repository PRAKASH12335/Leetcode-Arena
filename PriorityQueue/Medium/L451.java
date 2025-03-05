package PriorityQueue.Medium;

// 451. Sort Characters By Frequency

import java.util.HashMap;
import java.util.PriorityQueue;

public class L451 {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for (char c : map.keySet()) {
            pq.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            int count = map.get(c);
            while (count > 0) {
                sb.append(c);
                count--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(new L451().frequencySort(s));
    }
}

// Time complexity - O(N * logN)
// Space complexity - O(N)