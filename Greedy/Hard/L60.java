package Greedy.Hard;

// 60. Permutation Sequence

import java.util.ArrayList;
import java.util.List;

public class L60 {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i < n; i++) {
            numbers.add(i);
            fact *= i;
        }
        numbers.add(n);
        k = k - 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(numbers.get(k / fact));
            numbers.remove(k / fact);
            if (numbers.isEmpty())
                break;
            k = k % fact;
            fact = fact / numbers.size();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int n = 4, k = 9;
        System.out.println(new L60().getPermutation(n, k));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(N)