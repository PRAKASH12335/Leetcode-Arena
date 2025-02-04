package Greedy.Easy;

// 605. Can Place Flowers

public class L605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean isLeftEmpty = i == 0 || flowerbed[i - 1] == 0;
                boolean isRightEmpty = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
                if (isLeftEmpty && isRightEmpty) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 2;
        System.out.println(new L605().canPlaceFlowers(flowerbed, n));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)