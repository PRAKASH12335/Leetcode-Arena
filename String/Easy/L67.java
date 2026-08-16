package String.Easy;

// 67. Add Binary

public class L67 {

    public String addBinary(String a, String b) {
        int m = a.length(), n = b.length();
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (m > 0 || n > 0) {
            int sum = carry;
            if (m > 0) {
                sum += a.charAt(m - 1) - '0';
                m--;
            }
            if (n > 0) {
                sum += b.charAt(n - 1) - '0';
                n--;
            }
            sb.insert(0, sum % 2);
            carry = sum / 2;
        }
        if (carry > 0)
            sb.insert(0, 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "1010", b = "1011";
        System.out.println(new L67().addBinary(a, b));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)