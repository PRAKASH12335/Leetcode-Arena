package Arrays.Medium;

// 2007. Find Original Array From Doubled Array

import java.util.*;

public class L2007 {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 == 1) return new int[]{};

        Arrays.sort(changed);
        Map<Integer, Integer> map = new HashMap<>();
        for (int data : changed) {
            map.put(data, map.getOrDefault(data, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (int data : changed) {
            int twice = 2 * data;
            if (!map.containsKey(data) || map.get(data) == 0) continue;

            if (!map.containsKey(twice) || map.get(twice) == 0)
                return new int[]{};
            map.put(data, map.get(data) - 1);
            map.put(twice, map.get(twice) - 1);
            ans.add(data);
        }
        int[] arr = ans.stream().mapToInt(i -> i).toArray();
        return arr;
    }

    public static void main(String[] args) {
        int[] changed = {1, 3, 4, 2, 6, 8};
        int[] ans = new L2007().findOriginalArray(changed);
        Arrays.stream(ans).forEach(a -> System.out.println(a + " "));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)