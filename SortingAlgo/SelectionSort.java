package SortingAlgo;

// Selection Sort

import java.util.Arrays;

public class SelectionSort {
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void selectionSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            swap(i, minIndex, nums);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 1, 5, 3};
        SelectionSort ss = new SelectionSort();
        ss.selectionSort(nums);
        Arrays.stream(nums).forEach(a -> System.out.println(a));
    }
}

// Time Complexity - O(N^2)
// Space Complexity - O(1)