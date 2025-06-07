package Stack.Medium;

// 456. 132 Pattern

import java.util.Stack;

public class L456 {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int secondMax = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (secondMax > nums[i]) return true;
            while (!st.isEmpty() && nums[i] > st.peek()) {
                secondMax = st.peek();
                st.pop();
            }
            st.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {9, 4, 2, 8, 3, 1, 2};
        System.out.println(new L456().find132pattern(nums));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)