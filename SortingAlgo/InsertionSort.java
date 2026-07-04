package SortingAlgo;

// Insertion Sort

import java.util.Arrays;

public class InsertionSort {
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

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
        is.insertionSorting(nums);
        Arrays.stream(nums).forEach(a -> System.out.println(a));
    }

    // Striver's Algo
    private void insertionSorting(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && nums[j] < nums[j - 1]) {
                swap(j, j - 1, nums);
                j--;
            }
        }
    }
}

// Time Complexity - O(N^2)
// Space Complexity - O(1)