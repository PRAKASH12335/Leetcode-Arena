package TwoPointers.Easy;

// 643. Maximum Average Subarray I

public class L643 {

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0, start = 0;
        double maxAverage = Double.NEGATIVE_INFINITY;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k - 1) {
                maxAverage = Math.max(maxAverage, 1.0 * sum / k);
                sum -= nums[start];
                start++;
            }
        }
        return maxAverage;
    }

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        System.out.println(new L643().findMaxAverage(nums, k));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)