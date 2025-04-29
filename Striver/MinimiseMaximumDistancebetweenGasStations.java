package Striver;

// Minimise Maximum Distance between Gas Stations

import java.util.PriorityQueue;

public class MinimiseMaximumDistancebetweenGasStations {
    public static class Pair {
        double first;
        int second;

        public Pair(double first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public double minimiseMaxDistance(int[] stations, int k) {
        int n = stations.length;
        int[] midStations = new int[n - 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));
        for (int i = 0; i < n - 1; i++) {
            pq.add(new Pair(stations[i + 1] - stations[i], i));
        }

        for (int gasStation = 1; gasStation <= k; gasStation++) {
            Pair p = pq.poll();
            int secInd = p.second;
            midStations[secInd]++;
            double iniDiff = stations[secInd + 1] - stations[secInd];
            double sectionLength = iniDiff / (double) (midStations[secInd] + 1);
            pq.add(new Pair(sectionLength, secInd));
        }
        return pq.peek().first;
    }

    public static void main(String[] args) {
        int[] stations = {1, 13, 17, 23};
        int k = 5;
        System.out.println(new MinimiseMaximumDistancebetweenGasStations().minimiseMaxDistance(stations, k));
    }
}

// Time Complexity: O(nlogn + klogn),  n = size of the given array, k = no. of gas stations to be placed.
// Reason: Insert operation of priority queue takes logn time complexity. O(nlogn) for inserting all the indices with distance values and O(klogn) for placing the gas stations.
//
// Space Complexity: O(n-1)+O(n-1)
// Reason: The first O(n-1) is for the array to keep track of placed gas stations and the second one is for the priority queue.
