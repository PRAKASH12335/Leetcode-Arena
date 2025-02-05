package Stack.Medium;

// 962. Maximum Width Ramp

import java.util.Stack;

public class L962 {

    public int maxWidthRamp(int[] nums) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (st.isEmpty() || nums[st.peek()] > nums[i]) {
                st.push(i);
            }
        }
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] >= nums[st.peek()]) {
                ans = Math.max(ans, i - st.pop());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {6, 0, 8, 2, 1, 5};
        System.out.println(new L962().maxWidthRamp(nums));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)