package Greedy.Easy;

// 561. Array Partition

import java.util.Arrays;

public class L561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for(int i=0;i<n;i=i+2){
            ans += nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {6,2,6,5,1,2};
        System.out.println(new L561().arrayPairSum(nums));
    }
}

// Time Complexity - O(N*LogN)
// Space Complexity - O(1)