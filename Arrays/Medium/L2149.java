package Arrays.Medium;

// 2149. Rearrange Array Elements by Sign

import java.util.Arrays;

public class L2149 {

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int posInd = 0, negInd = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans[posInd] = nums[i];
                posInd += 2;
            }
            if (nums[i] < 0) {
                ans[negInd] = nums[i];
                negInd += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, -2, -5, 2, -4};
        int[] ans = new L2149().rearrangeArray(nums);
        Arrays.stream(ans).forEach(a -> System.out.print(a + " "));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)