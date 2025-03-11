package TwoPointers.Medium;

// 1358. Number of Substrings Containing All Three Characters

import java.util.Arrays;

public class L1358 {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] arr = new int[3];
        int cnt = 0;
        Arrays.fill(arr, -1);
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a'] = i;
            if (arr[0] != -1 && arr[1] != -1 && arr[2] != -1) {
                cnt = cnt + 1 + Math.min(Math.min(arr[0], arr[1]), arr[2]);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(new L1358().numberOfSubstrings(s));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)