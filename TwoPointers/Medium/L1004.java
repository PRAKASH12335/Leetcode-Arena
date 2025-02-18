package TwoPointers.Medium;

// 1004. Max Consecutive Ones III

public class L1004 {

    public int longestOnes(int[] nums, int k) {
        int maxCount = 0, zeroes = 0, end = 0, start = 0;
        while (end < nums.length) {
            if (nums[end] == 0) {
                zeroes++;
            }
            if (zeroes > k) {
                if (nums[start] == 0) {
                    zeroes--;
                }
                start++;
            }
            maxCount = Math.max(maxCount, end - start + 1);
            end++;
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(new L1004().longestOnes(nums, k));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)