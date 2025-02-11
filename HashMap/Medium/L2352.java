package HashMap.Medium;

// 2352. Equal Row and Column Pairs

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L2352 {
    public int equalPairs(int[][] grid) {
        HashMap<List<Integer>, Integer> data = new HashMap<>();
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(grid[i][j]);
            }
            data.put(list, data.getOrDefault(list, 0) + 1);
        }

        int ans = 0;
        for (int j = 0; j < n; j++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                list.add(grid[i][j]);
            }
            if (data.containsKey(list)) {
                ans += data.get(list);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}};
        System.out.println(new L2352().equalPairs(grid));
    }
}

// Time Complexity - O(N^2)
// Space Complexity - O(N)