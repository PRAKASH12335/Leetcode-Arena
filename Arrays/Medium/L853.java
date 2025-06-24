package Arrays.Medium;

// 853. Car Fleet

import java.util.Arrays;
import java.util.Comparator;

class CarState {
    int distanceFromTarget;
    int speed;
    double time;

    public CarState(int distanceFromTarget, int speed, double time) {
        this.distanceFromTarget = distanceFromTarget;
        this.speed = speed;
        this.time = time;
    }
}

public class L853 {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        CarState[] carState = new CarState[n];
        for (int i = 0; i < n; i++) {
            carState[i] = new CarState(target - position[i], speed[i], (target - position[i]) / speed[i]);
        }
        Arrays.sort(carState, new Comparator<CarState>() {
            @Override
            public int compare(CarState o1, CarState o2) {
                return o1.distanceFromTarget - o2.distanceFromTarget;
            }
        });

        int fleetCount = 0;
        double prevTime = 0;
        for (int i = 0; i < n; i++) {
            if (carState[i].time > prevTime) {
                fleetCount++;
                prevTime = carState[i].time;
            }
        }
        return fleetCount;
    }

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3}, speed = {2, 4, 1, 1, 3};
        System.out.println(new L853().carFleet(target, position, speed));
    }
}

// Time Complexity - O(N * log N)
// Space Complexity - O(N)