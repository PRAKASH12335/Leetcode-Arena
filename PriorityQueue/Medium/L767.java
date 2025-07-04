package PriorityQueue.Medium;

// 767. Reorganize String

import java.util.HashMap;
import java.util.PriorityQueue;

public class L767 {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
            if (count[c - 'a'] > (n + 1) / 2)
                return "";
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0)
                pq.add(new int[]{i, count[i]});
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() >= 2) {
            int[] a = pq.poll();
            int[] b = pq.poll();
            char first = (char) (a[0] + 'a');
            char second = (char) (b[0] + 'a');
            sb.append(first).append(second);
            if (a[1] - 1 > 0)
                pq.add(new int[]{a[0], a[1] - 1});
            if (b[1] - 1 > 0)
                pq.add(new int[]{b[0], b[1] - 1});
        }
        while (!pq.isEmpty()) {
            sb.append((char) (pq.poll()[0] + 'a'));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new L767().reorganizeString(s));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)