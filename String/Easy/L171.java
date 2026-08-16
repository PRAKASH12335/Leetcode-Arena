package String.Easy;

// 171. Excel Sheet Column Number

public class L171 {
    public int titleToNumber(String columnTitle) {
        int power = 0, result = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int num = (columnTitle.charAt(i) - 'A' + 1) * (int) Math.pow(26, power++);
            result += num;
        }
        return result;
    }

    public static void main(String[] args) {
        String columnTitle = "ZY";
        System.out.println(new L171().titleToNumber(columnTitle));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)