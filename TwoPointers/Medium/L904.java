package TwoPointers.Medium;

// 904. Fruit Into Baskets

import java.util.HashMap;

public class L904 {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = 0, maxCount = 0;
        for (int i = 0; i < n; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[start], map.get(fruits[start]) - 1);
                if (map.get(fruits[start]) == 0) {
                    map.remove(fruits[start]);
                }
                start++;
            }
            maxCount = Math.max(maxCount, i - start + 1);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] fruits = {1, 2, 1};
        System.out.println(new L904().totalFruit(fruits));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)