package TwoPointers.Medium;

// 1423. Maximum Points You Can Obtain from Cards

public class L1423 {
    public int maxScore(int[] cardPoints, int k) {
        int score = 0, n = cardPoints.length, maxScore = 0;
        for (int i = 0; i < k; i++) {
            score += cardPoints[i];
        }
        maxScore = Math.max(maxScore, score);

        int nIndex = n - 1;
        for (int i = k - 1; i >= 0; i--) {
            score += cardPoints[nIndex];
            score -= cardPoints[i];
            maxScore = Math.max(maxScore, score);
            nIndex--;
        }
        return maxScore;
    }

    public static void main(String[] args) {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        System.out.println(new L1423().maxScore(cardPoints, k));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)