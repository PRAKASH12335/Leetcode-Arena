package String.Easy;

// 520. Detect Capital

public class L520 {
    public boolean detectCapitalUse(String word) {
        int count = 0, n = word.length();
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c))
                count++;
        }
        return count == 0 || count == n || count == 1 && Character.isUpperCase(word.charAt(0));
    }

    public static void main(String[] args) {
        String word = "USA";
        System.out.println(new L520().detectCapitalUse(word));
    }
}

// Time Complexity - O(N))
// Space Complexity - O(1)