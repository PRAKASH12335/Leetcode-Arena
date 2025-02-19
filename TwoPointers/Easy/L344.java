package TwoPointers.Easy;

// 344. Reverse String

public class L344 {

    public void reverseString(char[] s) {
        int low = 0, high = s.length - 1;
        while (low < high) {
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        new L344().reverseString(s);
        System.out.print(s);
    }
}

// Time Complexity - O(1)
// Space Complexity - O(1)