package HashMap.Medium;

// 202. Happy Number

import java.util.HashSet;

public class L202 {

    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while (n != 1) {
            int num = n;
            int sum = 0;
            while (num > 0) {
                int rem = num % 10;
                sum += rem * rem;
                num = num / 10;
            }
            if (seen.contains(sum))
                return false;
            seen.add(sum);
            n = sum;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(new L202().isHappy(n));
    }
}

// Time complexity - O(log N)
// Space complexity - O(log N)