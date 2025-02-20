package HashMap.Medium;

// 128. Longest Consecutive Sequence

import java.util.HashSet;

public class L128 {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int count = 1, num = nums[i];
                while (set.contains(num + 1)) {
                    count++;
                    num = num + 1;
                }
                maxLength = Math.max(maxLength, count);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.print(new L128().longestConsecutive(nums));
    }
}

// Time complexity - O(N)
// Space complexity - O(N)