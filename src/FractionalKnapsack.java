import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        int numberOfItems = weights.length;
        Item[] items = new Item[numberOfItems];


        for (int i = 0; i < numberOfItems; i++) {
            items[i] = new Item(weights[i], values[i]);
        }

        Arrays.sort(items, Comparator.comparingDouble((FractionalKnapsack.Item i) -> i.valuePerWeight).reversed());

        int capacityLeft = capacity;
        int i = 0;
        double returnWeight = 0;

        while (capacityLeft > 0 && i < numberOfItems) {
            int possibleItemWeight = Math.min(items[i].weight, capacityLeft);
            capacityLeft -= possibleItemWeight;
            returnWeight += items[i].valuePerWeight * possibleItemWeight;
            i++;
        }

        return returnWeight;
    }

    private static class Item {
        int weight, value;
        double valuePerWeight;

        Item(int start, int end) {
            this.weight = start;
            this.value = end;
            this.valuePerWeight = this.value * 1.0 / this.weight;
        }

        @Override
        public String toString() {
            return "| W: " + weight + " V: " + value + " |";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        // Input 3 50 60 20 100 50 120 30
        // Output 180.00
        // Input 1 1000 500 30
        // Output 500.00
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
