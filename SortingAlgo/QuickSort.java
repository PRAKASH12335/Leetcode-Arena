package SortingAlgo;

// Quick Sort

import java.util.Arrays;

public class QuickSort {
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

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
        QuickSort qs = new QuickSort();
        qs.quickSort(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(a -> System.out.println(a));
    }
}

// Time Complexity - O(N * N)
// Space Complexity - O(N)