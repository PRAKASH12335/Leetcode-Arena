package SegmentTree.Hard;

// 2940. Find Building Where Alice and Bob Can Meet

import java.util.Arrays;

class SegmentTree {
    long[] tree;
    long[] values;
    int size;

    SegmentTree(int[] arr) {
        this.size = arr.length;
        this.values = new long[size];
        for (int i = 0; i < size; i++) {
            values[i] = arr[i];
        }
        this.tree = new long[4 * size];
        buildSegmentTree(0, 0, size - 1);
    }

    public void buildSegmentTree(int i, int left, int right) {
        if (left == right) {
            tree[i] = values[left];
            return;
        }
        int mid = left + (right - left) / 2;
        buildSegmentTree(2 * i + 1, left, mid);
        buildSegmentTree(2 * i + 2, mid + 1, right);
        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    public long query(int i, int l, int r, int start, int end) {
        if (l > end || r < start)
            return Long.MIN_VALUE;
        if (l >= start && r <= end)
            return tree[i];
        int mid = l + (r - l) / 2;
        long leftResult = query(2 * i + 1, l, mid, start, end);
        long rightResult = query(2 * i + 2, mid + 1, r, start, end);
        return Math.max(leftResult, rightResult);
    }
}

public class L2940 {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int n = heights.length;
        SegmentTree segmentTree = new SegmentTree(heights);
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            int threshold = Math.max(heights[a], heights[b]);
            if (heights[a] < heights[b] || a == b) {
                result[i] = b;
                continue;
            }
            int left = b, right = n - 1;
            if (segmentTree.query(0, 0, n - 1, b, n - 1) <= threshold) {
                result[i] = -1;
                continue;
            }
            while (left <= right) {
                int mid = (left + right) / 2;
                long maxInRange = segmentTree.query(0, 0, n - 1, b, mid);
                if (maxInRange > threshold) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            result[i] = heights[left] <= threshold ? -1 : left;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] heights = {6, 4, 8, 5, 2, 7};
        int[][] queries = {{0, 1}, {0, 3}, {2, 4}, {3, 4}, {2, 2}};
        int[] result = new L2940().leftmostBuildingQueries(heights, queries);
        Arrays.stream(result).forEach(a -> System.out.print(a + " "));
    }
}

// Time complexity - O(N + M)
// Space complexity - O(4 * N)