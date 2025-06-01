package SegmentTree.Hard;

// 2179. Count Good Triplets in an Array

import java.util.HashMap;
import java.util.Map;

public class L2179 {
    private long[] segTree;

    private void updateSegmentTree(int i, int l, int r, int idx, long[] segTree) {
        if (l == r) {
            segTree[i] = 1; // mark visited
            return;
        }
        int mid = l + (r - l) / 2;
        if (idx <= mid)
            updateSegmentTree(2 * i + 1, l, mid, idx, segTree);
        else
            updateSegmentTree(2 * i + 2, mid + 1, r, idx, segTree);
        segTree[i] = segTree[2 * i + 1] + segTree[2 * i + 2];
    }

    private long querySegmentTree(int i, int start, int end, int l, int r, long[] segTree) {
        if (l > end || r < start)
            return 0;
        if (l >= start && r <= end)
            return segTree[i];
        int mid = l + (r - l) / 2;
        long left = querySegmentTree(2 * i + 1, start, end, l, mid, segTree);
        long right = querySegmentTree(2 * i + 2, start, end, mid + 1, r, segTree);
        return left + right;
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(nums2[i], i);
        }

        long[] segmentTree = new long[4 * n];
        long result = 0;

        updateSegmentTree(0, 0, n - 1, mp.get(nums1[0]), segmentTree);

        for (int i = 1; i < n; i++) {
            int idx = mp.get(nums1[i]);
            long leftCommonCount = querySegmentTree(0, 0, idx, 0, n - 1, segmentTree);
            long leftNotCommonCount = i - leftCommonCount;
            long elementsAfterIdxNums2 = (n - 1) - idx;
            long rightCommonCount = elementsAfterIdxNums2 - leftNotCommonCount;
            result += leftCommonCount * rightCommonCount;

            updateSegmentTree(0, 0, n - 1, idx, segmentTree);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 0, 1, 3, 2}, nums2 = {4, 1, 0, 2, 3};
        System.out.println(new L2179().goodTriplets(nums1, nums2));
    }
}

// Time complexity - O(N * logN)
// Space complexity - O(4 * N)