package Misc;

// 38. Count and Say

public class L38 {
    public String countAndSay(int n) {
        if (n == 0)
            return "";
        String result = "1";
        for (int i = 1; i < n; i++) {
            int len = result.length();
            int count = 1;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                if (j < len - 1 && result.charAt(j) == result.charAt(j + 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(result.charAt(j));
                    count = 1;
                }
            }
            result = sb.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(new L38().countAndSay(n));
    }
}

// Time Complexity - O(N*L)
// Space Complexity - O(N)