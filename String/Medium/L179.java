package Misc;

// 179. Largest Number

import java.util.Arrays;
import java.util.Comparator;

public class L179 {
    class CustomComparator implements Comparator<String> {
        public int compare(String s1, String s2) {
            String str1 = s1 + s2;
            String str2 = s2 + s1;
            return str2.compareTo(str1);
        }
    }

    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Comparator comp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String str1 = s1 + s2;
                String str2 = s2 + s1;
                return str2.compareTo(str1);
            }
        };
        Arrays.sort(str, comp);

        if (str[0].equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(new L179().largestNumber(nums));
    }
}

// Time Complexity - O(N * logN)
// Time Complexity - O(N)