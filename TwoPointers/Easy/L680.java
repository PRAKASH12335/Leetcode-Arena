package TwoPointers.Easy;

// 680. Valid Palindrome II

public class L680 {
    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        while (low <= high) {
            if (s.charAt(low) != s.charAt(high))
                return isPalindrome(s, low + 1, high) || isPalindrome(s, low, high - 1);
            low++;
            high--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abca";
        System.out.println(new L680().validPalindrome(s));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)