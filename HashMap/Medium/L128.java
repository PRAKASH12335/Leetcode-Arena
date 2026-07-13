package HashMap.Medium;

// 128. Longest Consecutive Sequence

import java.util.Arrays;
import java.util.HashSet;

public class L128 {
    public int longestConsecutiveBetter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int curr = 0, maxLength = 0, lastSmaller = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 == lastSmaller) {
                curr++;
                lastSmaller = nums[i];
            } else if (nums[i] != lastSmaller) {
                curr = 1;
                lastSmaller = nums[i];
            }
            maxLength = Math.max(maxLength, curr);
        }
        return maxLength;
    }
    // Time complexity - O(N*logN + N)
    // Space complexity - O(1)

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

    // Time complexity - O(N)
    // Space complexity - O(N)

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        L128 obj = new L128();
        System.out.println(obj.longestConsecutiveBetter(nums));
        System.out.print(obj.longestConsecutive(nums));
    }
}
