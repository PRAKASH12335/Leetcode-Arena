package String.Easy;

// 28. Find the Index of the First Occurrence in a String

public class L28 {

    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        if (n > m)
            return -1;

        for (int i = 0; i < m; i++) {
            if (i + n > m)
                return -1;
            int k = i;
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(k) == needle.charAt(j)) {
                    k++;
                    if (j == needle.length() - 1)
                        return i;
                } else
                    break;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        System.out.println(new L28().strStr(haystack, needle));
    }
}

// Time Complexity - O(N * M)
// Space Complexity - O(1)