package SortingAlgo;

// Heap Sort

import java.util.Arrays;

public class HeapSort {
    private void heapify(int[] nums, int n, int i) {
        int largest = i;   // Initialize largest as root
        int left = 2 * i + 1;  // left index = 2*i + 1
        int right = 2 * i + 2; // right index = 2*i + 1
        if (left < n && nums[left] > nums[largest]) {  // If left child is larger than root
            largest = left;
        }
        if (right < n && nums[right] > nums[largest]) { // If right child is larger than largest so far
            largest = right;
        }
        if (largest != i) { // If largest is not root
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;

            heapify(nums, n, largest);
        }
    }

    private void heapSort(int[] nums) {
        int n = nums.length;
        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            heapify(nums, i, 0); // Call max heapify on the reduced heap
        }
    }

    public static void main(String[] args) {
        int nums[] = {9, 4, 3, 8, 10, 2, 5};
        HeapSort hs = new HeapSort();
        hs.heapSort(nums);
        Arrays.stream(nums).forEach(a -> System.out.println(a));
    }
}

// Time Complexity - O(N * logN)
// Space Complexity - O(logN)