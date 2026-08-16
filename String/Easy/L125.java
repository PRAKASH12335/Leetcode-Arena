package String.Easy;

// 125. Valid Palindrome

public class L125 {
    public boolean isPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
                if (ch >= 'A' && ch <= 'Z')
                    ch = (char) (ch + 32);
                sb.append(ch);
            }
        }

        int l = 0, h = sb.length() - 1;
        while (l <= h) {
            if (sb.charAt(l) != sb.charAt(h))
                return false;
            l++;
            h--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new L125().isPalindrome(s));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)