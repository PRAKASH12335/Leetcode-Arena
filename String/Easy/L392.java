package String.Easy;

// 392. Is Subsequence

public class L392 {
    private boolean helper(String s, String t, int m, int n) {
        if ((m == 0 && n == 0) || m == 0)
            return true;
        if (m == 0 || n == 0)
            return false;
        if (s.charAt(m - 1) == t.charAt(n - 1))
            return helper(s, t, m - 1, n - 1);
        else
            return helper(s, t, m, n - 1);
    }

    public boolean isSubsequence(String s, String t) {
        return helper(s, t, s.length(), t.length());
    }

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(new L392().isSubsequence(s, t));
    }
}

// Time Complexity - O(min(M, N))
// Time Complexity - O(1)