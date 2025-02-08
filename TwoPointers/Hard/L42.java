package TwoPointers.Hard;

// 42. Trapping Rain Water

public class L42 {

    // DP Approach
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        int[] right = new int[n];
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(left[i], right[i]) - height[i];
        }
        return ans;
    }

    // Time Complexity - O(3N) ~ O(N)
    // Space Complexity - O(N)


    // Two Pointer Approach
    public int trap2(int[] height) {
        int n = height.length;
        int low = 0, high = n - 1, leftMax = 0, rightMax = 0, water = 0;
        while (low < high) {
            if (height[low] < height[high]) {
                if (leftMax < height[low])
                    leftMax = height[low];
                else
                    water += leftMax - height[low];
                low++;
            } else {
                if (rightMax < height[high])
                    rightMax = height[high];
                else
                    water += rightMax - height[high];
                high--;
            }
        }
        return water;
    }

    // Time Complexity - O(N)
    // Space Complexity - O(1)

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new L42().trap2(height));
    }
}