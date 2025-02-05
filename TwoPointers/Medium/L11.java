package TwoPointers.Medium;

// 11. Container With Most Water

public class L11 {

    public int maxArea(int[] height) {
        int ans = 0, l = 0, h = height.length - 1;
        while (l < h) {
            ans = Math.max(ans, (h - l) * Math.min(height[l], height[h]));
            if (height[l] < height[h])
                l++;
            else
                h--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new L11().maxArea(height));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)