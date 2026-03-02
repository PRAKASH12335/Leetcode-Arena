package TwoPointers.Easy;

// 977. Squares of a Sorted Array

import java.util.Arrays;

public class L977 {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int i = 0, j = n-1;
        int index = n-1;
        int[] ans = new int[n];
        while(i <= j){
            int start = nums[i]*nums[i];
            int end = nums[j]*nums[j];
            if(start > end){
                ans[index--] = start;
                i++;
            }else{
                ans[index--] = end;
                j--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-7,-3,2,3,11};
        int[] ans = new L977().sortedSquares(arr);
        Arrays.stream(ans).forEach(a -> System.out.print(a + " "));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)