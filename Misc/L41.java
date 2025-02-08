package Misc;

// 41. First Missing Positive

public class L41 {

    private int segregateNegativeElements(int[] nums, int n) {
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return j;
    }

    public int firstMissingPositiveUtil(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (index < n && arr[index] > 0) {
                arr[index] = -arr[index];
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0)
                return i + 1;
        }
        return n + 1;
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int shift = segregateNegativeElements(nums, n);
        int[] arr = new int[n - shift];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i + shift];
        }
        return firstMissingPositiveUtil(arr, arr.length);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 3};
        System.out.println(new L41().firstMissingPositive(nums));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)