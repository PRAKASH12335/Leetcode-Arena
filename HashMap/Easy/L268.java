package HashMap.Easy;

// 268. Missing Number

public class L268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans ^= nums[i] ^ (i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(new L268().missingNumber(nums));
    }
}

// Time complexity - O(N)
// Space complexity - O(1)