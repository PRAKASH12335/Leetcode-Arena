package TwoPointers.Easy;

// 345. Reverse Vowels of a String

public class L345 {
    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
            return true;
        return false;
    }

    public String reverseVowels(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        char[] str = s.toCharArray();
        if (n == 0)
            return "";
        while (i < j) {
            if (!isVowel(str[i])) {
                i++;
                continue;
            }
            if (!isVowel(str[j])) {
                j--;
                continue;
            }
            char c = str[i];
            str[i] = str[j];
            str[j] = c;
            i++;
            j--;
        }
        return new String(str);
    }

    public static void main(String[] args) {
        String s = "IceCreAm";
        System.out.print(new L345().reverseVowels(s));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)