import java.util.*;

public class FibonacciLastDigit {
    private static int[] getFibonacciFirst60(int[] n_array) {
        n_array[0] = 0;
        n_array[1] = 1;


        for (int i = 2; i < 60; ++i) {
            n_array[i] = n_array[i - 1] + n_array[i - 2];
            n_array[i] %= 10;
        }

        return n_array;
    }

    // Returns last digit of n'th Fibonacci Number 
    static int findLastDigit(int[] first60Fib, long n)
    {
        getFibonacciFirst60(first60Fib);

        int index = (int)(n % 60L);

        return first60Fib[index];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] first60Fib = getFibonacciFirst60(new int[60]);
        int c = findLastDigit(first60Fib, n);
        System.out.println(c);
    }
}

