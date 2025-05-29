package SortingAlgo;

// Bubble Sort

import java.util.Arrays;

public class BubbleSort {
    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void bubbleSort(int[] nums) {
        int n = nums.length;
        boolean flag = false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(j, j + 1, nums);
                    flag = true;
                }
            }
            if (flag == false)
                break;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 4, 1, 5, 3};
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(nums);
        Arrays.stream(nums).forEach(a -> System.out.println(a));
    }
}

// Time Complexity - O(N^2)
// Space Complexity - O(1)