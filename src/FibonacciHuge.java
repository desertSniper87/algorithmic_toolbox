import java.math.BigInteger;
import java.util.*;

public class FibonacciHuge {
    private static BigInteger getFibonacciHugeNaive(BigInteger n, BigInteger m) {
        if (n.intValue() <= 1)
            return n;

        BigInteger previous = BigInteger.ZERO;
        BigInteger current  = BigInteger.ONE;

        for (BigInteger i = BigInteger.valueOf(2); !n.add(BigInteger.ONE).equals(i); i = i.add(BigInteger.ONE)) {
            BigInteger tmp_previous = previous;
            previous = current;
            current = tmp_previous.add(current);
        }

        return current.mod(m);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger n = scanner.nextBigInteger();
        BigInteger m = scanner.nextBigInteger();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}

