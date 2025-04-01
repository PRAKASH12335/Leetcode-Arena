package Misc;

// 169. Majority Element

public class L169 {

    public int majorityElement(int[] nums) {
        int maj_ele = -1, count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                maj_ele = nums[i];
                count = 1;
            } else {
                count += maj_ele == nums[i] ? 1 : -1;
            }
        }
        return maj_ele;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(new L169().majorityElement(nums));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)