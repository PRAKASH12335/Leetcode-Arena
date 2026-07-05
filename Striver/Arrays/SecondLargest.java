package Striver.Arrays;

// Second Largest Element in an Array

public class SecondLargest {
    private int secondLargestElement(int[] nums) {
        int largest = nums[0], secLargest = -1;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] > largest) {
                secLargest = largest;
                largest = nums[i];
            } else if (nums[i] < largest && nums[i] > secLargest) {
                secLargest = nums[i];
            }
        }
        return secLargest;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 7, 7, 5};
        SecondLargest sl = new SecondLargest();
        System.out.println(sl.secondLargestElement(nums));
    }
}

// Time Complexity - O(N)
// Time Complexity - O(1)
