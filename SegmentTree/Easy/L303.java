package SegmentTree.Easy;

// 303. Range Sum Query - Immutable

public class L303 {
    int n;
    int[] segmentTree;

    public L303(int[] nums) {
        n = nums.length;
        segmentTree = new int[4 * n];
        buildSegmentTree(0, 0, n - 1, nums);
    }

    public int sumRange(int left, int right) {
        return querySegemntTree(left, right, 0, 0, n - 1);
    }

    private void buildSegmentTree(int i, int l, int r, int[] nums) {
        if (l == r) {
            segmentTree[i] = nums[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildSegmentTree(2 * i + 1, l, mid, nums);
        buildSegmentTree(2 * i + 2, mid + 1, r, nums);
        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }

    private int querySegemntTree(int start, int end, int i, int l, int r) {
        if (end < l || r < start)
            return 0;
        if (l >= start && r <= end)
            return segmentTree[i];
        int mid = l + (r - l) / 2;
        return querySegemntTree(start, end, 2 * i + 1, l, mid) + querySegemntTree(start, end, 2 * i + 2, mid + 1, r);
    }

    public static void main(String[] args) {
        L303 numArray = new L303(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2)); // return (-2) + 0 + 3 = 1
        System.out.println(numArray.sumRange(2, 5)); // return 3 + (-5) + 2 + (-1) = -1
        System.out.println(numArray.sumRange(0, 5)); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
    }
}

// Time Complexity - Constructor: O(N),
//                   sumRange- O(logN)
// Space Complexity - O(N)