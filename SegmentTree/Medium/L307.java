package SegmentTree.Medium;

// 307. Range Sum Query - Mutable

public class L307 {
    int n;
    int[] segmentTree;

    public L307(int[] nums) {
        n = nums.length;
        segmentTree = new int[4 * n];
        buildSegmentTree(0, 0, n - 1, nums);
    }

    private void buildSegmentTree(int i, int start, int end, int[] nums) {
        if (start == end) {
            segmentTree[i] = nums[start];
            return;
        }
        int mid = start + (end - start) / 2;
        buildSegmentTree(2 * i + 1, start, mid, nums);
        buildSegmentTree(2 * i + 2, mid + 1, end, nums);
        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }

    public void update(int index, int val) {
        updateSegmentTree(index, val, 0, 0, n - 1);
    }

    private void updateSegmentTree(int index, int val, int i, int start, int end) {
        if (start == end) {
            segmentTree[i] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if (index <= mid)
            updateSegmentTree(index, val, 2 * i + 1, start, mid);
        else
            updateSegmentTree(index, val, 2 * i + 2, mid + 1, end);
        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }

    public int sumRange(int left, int right) {
        return querySegmentTree(left, right, 0, 0, n - 1);
    }

    private int querySegmentTree(int left, int right, int i, int start, int end) {
        if (start > right || end < left)
            return 0;
        if (start >= left && end <= right)
            return segmentTree[i];
        int mid = start + (end - start) / 2;
        return querySegmentTree(left, right, 2 * i + 1, start, mid) +
                querySegmentTree(left, right, 2 * i + 2, mid + 1, end);
    }

    public static void main(String[] args) {
        L307 numArray = new L307(new int[]{1, 3, 5});
        System.out.println(numArray.sumRange(0, 2)); // return 1 + 3 + 5 = 9
        numArray.update(1, 2);   // nums = [1, 2, 5]
        System.out.println(numArray.sumRange(0, 2));
    }
}

// Time Complexity - Constructor: O(N),
//                   Update, sumRange- O(logN)
// Space Complexity - O(N)