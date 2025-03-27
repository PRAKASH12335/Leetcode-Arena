package TwoPointers.Medium;

// 881. Boats to Save People

import java.util.Arrays;

public class L881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int cnt = 0;
        int i = 0, j = people.length - 1;
        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
                j--;
            } else
                j--;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] people = {3, 2, 2, 1};
        int limit = 3;
        System.out.println(new L881().numRescueBoats(people, limit));
    }
}

// Time Complexity - O(N*logN)
// Space Complexity - O(1)