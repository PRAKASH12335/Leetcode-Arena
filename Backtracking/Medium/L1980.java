package Backtracking.Medium;

// 1980. Find Unique Binary String

public class L1980 {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] nums = {"01", "10"};
        System.out.println(new L1980().findDifferentBinaryString(nums));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)