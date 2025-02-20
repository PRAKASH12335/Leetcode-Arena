package TwoPointers.Easy;

// 125. Valid Palindrome

public class L125 {
    private boolean isCharacter(char ch) {
        if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')
            return true;
        return false;
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9') {
                if (ch >= 'A' && ch <= 'Z')
                    ch = (char) (ch + 32);
                sb.append(ch);
            }
        }

        int l = 0, h = sb.length() - 1;
        while (l < h) {
            if (sb.charAt(l) != sb.charAt(h))
                return false;
            l++;
            h--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.print(new L125().isPalindrome(s));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)