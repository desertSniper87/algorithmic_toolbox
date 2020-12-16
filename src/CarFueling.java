import java.util.*;
import java.io.*;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int numRefill = 0;
        int currentRefill = 0;
        int lastRefill = currentRefill;

        while (currentRefill <= stops.length) {
            lastRefill = currentRefill;
            while (currentRefill <= stops.length && stops[currentRefill+1] - stops[lastRefill] < dist) {
                currentRefill++;
            }
        }

        if (currentRefill == lastRefill) {
            return -1;
        }

        if (currentRefill <= stops.length) {
            numRefill++;
        }

        return numRefill;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int[] stops = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }
        // input: 950 400 4 200 375 550 750
        // Output: 2
        // input: 10 3 4 1 2 5 9
        // Output: -1
        // input 500 200 4 100 200 300 400
        // Output: 2
        // input 700 200 4 100 200 300 400
        // Output: -1
        // input 750 400 3 200 375 550

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
