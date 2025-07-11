package SortingAlgo;

// Merge Sort

import java.util.Arrays;

public class MergeSort {
    private void merge(int[] left, int[] right, int[] nums) {
        int m = left.length, n = right.length;
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (left[i] <= right[j]) {
                nums[k] = left[i];
                i++;
            } else {
                nums[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < m) {
            nums[k] = left[i];
            i++;
            k++;
        }
        while (j < n) {
            nums[k] = right[j];
            j++;
            k++;
        }
    }

    private void mergeSort(int[] nums) {
        int n = nums.length;
        if (n < 2) return;
        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = nums[i];
        }
        for (int i = mid; i < n; i++) {
            right[i - mid] = nums[i];
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, nums);
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 1, 5, 3};
        MergeSort ms = new MergeSort();
        ms.mergeSort(nums);
        Arrays.stream(nums).forEach(a -> System.out.println(a));
    }
}

// Time Complexity - O(N * logN)
// Space Complexity - O(N)