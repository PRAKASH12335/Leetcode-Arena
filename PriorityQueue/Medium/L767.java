package PriorityQueue.Medium;

// 767. Reorganize String

import java.util.HashMap;
import java.util.PriorityQueue;

public class L767 {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Character> maxPQ = new PriorityQueue<>((a, b) -> countMap.get(b) - countMap.get(a));
        for (char c : countMap.keySet()) {
            maxPQ.add(c);
        }
        StringBuilder sb = new StringBuilder();
        while (maxPQ.size() > 1) {
            char a = maxPQ.poll();
            char b = maxPQ.poll();
            sb.append(a).append(b);
            countMap.put(a, countMap.get(a) - 1);
            countMap.put(b, countMap.get(b) - 1);
            if (countMap.get(a) > 0)
                maxPQ.add(a);
            if (countMap.get(b) > 0)
                maxPQ.add(b);
        }
        if (maxPQ.size() == 1) {
            char temp = maxPQ.poll();
            if (countMap.get(temp) > 1)
                return "";
            else
                sb.append(temp);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(new L767().reorganizeString(s));
    }
}

// Time Complexity - O(N * logN)
// Space Complexity - O(N)