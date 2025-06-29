package Backtracking.Medium;

// 526. Beautiful Arrangement

public class L526 {
    int count = 0;

    public void permute(int[] nums, int l) {
        if (l == nums.length - 1) {
            int i;
            for (i = 1; i <= nums.length; i++) {
                if ((nums[i - 1] % i != 0 && i % nums[i - 1] != 0))
                    break;
            }
            if (i == nums.length + 1)
                count++;
        }
        for (int i = l; i < nums.length; i++) {
            swap(nums, i, l);
            permute(nums, l + 1);
            swap(nums, i, l);
        }
    }
    // Time Complexity - O(N!)
    // Space Complexity - O(N)

    public void permuteOptimised(int[] nums, int l) {
        if (l == nums.length) {
            count++;
        }
        for (int i = l; i < nums.length; i++) {
            swap(nums, i, l);
            if ((nums[l] % (l + 1) == 0 || (l + 1) % nums[l] == 0))
                permuteOptimised(nums, l + 1);
            swap(nums, i, l);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int countArrangement(int n) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        permuteOptimised(nums, 0);
        // permute(nums, 0);
        return count;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new L526().countArrangement(n));
    }
}

// Time Complexity - O(K), K = Number of valid permutation
// Space Complexity - O(N)