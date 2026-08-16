package String.Easy;

// 58. Length of Last Word

public class L58 {
    public int lengthOfLastWord(String s) {
        int count = 0;
        boolean isWord = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                count++;
                isWord = true;
            } else {
                if (isWord)
                    return count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(new L58().lengthOfLastWord(s));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)