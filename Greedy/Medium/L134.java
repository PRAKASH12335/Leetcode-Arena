package Greedy.Medium;

// 134. Gas Station

public class L134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalCost > totalGas)
            return -1;
        int start = 0, current = 0;
        for (int i = 0; i < gas.length; i++) {
            current += gas[i] - cost[i];
            if (current < 0) {
                start = i + 1;
                current = 0;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5}, cost = {3, 4, 5, 1, 2};
        System.out.print(new L134().canCompleteCircuit(gas, cost));
    }
}

// Time Complexity - O(N)
// Space Complexity - O(1)