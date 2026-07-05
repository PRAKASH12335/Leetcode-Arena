package SortingAlgo;

// Quick Sort

import java.util.Arrays;

public class QuickSort {
    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                swap(i, pIndex, nums);
                pIndex = pIndex + 1;
            }
        }
        swap(pIndex, end, nums);
        return pIndex;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int pIndex = partition(nums, start, end);
            quickSort(nums, start, pIndex - 1);
            quickSort(nums, pIndex + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 1, 5, 3};
        int[] nums1 = {2, 7, 4, 1, 5, 3};
        QuickSort qs = new QuickSort();
        qs.quickSort(nums, 0, nums.length - 1);
        qs.quickSorting(nums1, 0, nums.length - 1);
        Arrays.stream(nums).forEach(a -> System.out.print(a + " "));
        System.out.println();
        Arrays.stream(nums1).forEach(a -> System.out.print(a + " "));
    }

    // Striver's Quick Sort
    private void quickSorting(int[] nums, int low, int high) {
        if (low < high) {
            int pIndex = partitionIndex(nums, low, high);
            quickSorting(nums, low, pIndex - 1);
            quickSorting(nums, pIndex + 1, high);
        }
    }

    private int partitionIndex(int[] nums, int low, int high) {
        int pivot = nums[low];
        int i = low, j = high;
        while (i < j) {
            while (i <= high - 1 && pivot >= nums[i]) {
                i++;
            }
            while (j >= low + 1 && pivot < nums[j]) {
                j--;
            }
            if (i < j)
                swap(i, j, nums);
        }
        swap(j, low, nums);
        return j;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// Time Complexity - O(N * logN)
// Space Complexity - O(1)