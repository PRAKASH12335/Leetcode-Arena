package String.Easy;

// 3330. Find the Original Typed String I

public class L3330 {
    public int possibleStringCount(String word) {
        int cnt = 0;
        int i = 1, n = word.length();
        while (i < n) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                cnt++;
            }
            i++;
        }
        return cnt + 1;
    }

    public static void main(String[] args) {
        String word = "abbcccc";
        System.out.println(new L3330().possibleStringCount(word));
    }
}

// Time Complexity - O(N))
// Space Complexity - O(1)