package HashMap.Medium;

// 781. Rabbits in Forest

import java.util.HashMap;
import java.util.Map;

public class L781 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int ans : answers) {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            total += Math.ceil((double) entry.getValue() / (entry.getKey() + 1)) * (entry.getKey() + 1);
        }
        return total;
    }

    public static void main(String[] args) {
        int[] answers = {1, 1, 2, 2, 2, 2};
        System.out.println(new L781().numRabbits(answers));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)