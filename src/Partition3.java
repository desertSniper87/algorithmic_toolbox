import java.util.*;

public class Partition3 {
    private static int partition3(int[] array)
    {
        int numberOfItems = array.length;
        int sum = Arrays.stream(array).sum();
        int NUM_PART = 3;


        if (sum % NUM_PART != 0) {
            return 0;
        }
        int amountPerPartition = sum/NUM_PART;

        boolean[][] matrix = new boolean[amountPerPartition + 1][numberOfItems + 1];

        for (int item = 0; item <= numberOfItems; item++)
            matrix[0][item] = true;

        for (int value = 1; value <= amountPerPartition; value++) {
            for (int item = 1; item <= numberOfItems; item++) {
                matrix[value][item] = matrix[value][item - 1];
                if (value >= array[item - 1]) {
                    matrix[value][item] = matrix[value][item] || matrix[value - array[item - 1]][item - 1];
                }
            }
        }

        /*for (int value = 0; value <= amountPerPartition; value++) {
            for (int item = 0; item <= numberOfItems; item++)
                // System.out.printf("%b\t", matrix[value][item]);
            // System.out.print("\n");
        }*/
        if (matrix[amountPerPartition][numberOfItems]) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        // Input: 4 3 3 3 3
        // Input: 11 17 59 34 57 17 23 67 1 18 2 59
        // Input: 13 1 2 3 4 5 5 7 7 8 10 12 19 25


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
         System.out.println(partition3(A));
    }
}

