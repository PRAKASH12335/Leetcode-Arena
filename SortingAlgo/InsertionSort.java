package SortingAlgo;

// Insertion Sort

import java.util.Arrays;

public class InsertionSort {
    private void insertionSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int value = nums[i];
            int hole = i;
            while (hole > 0 && value < nums[hole - 1]) {
                nums[hole] = nums[hole - 1];
                hole = hole - 1;
            }
            nums[hole] = value;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 1, 5, 3};
        InsertionSort is = new InsertionSort();
        is.insertionSort(nums);
        Arrays.stream(nums).forEach(a -> System.out.println(a));
    }
}

// Time Complexity - O(N^2)
// Space Complexity - O(1)