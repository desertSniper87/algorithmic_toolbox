import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] givenNumber) {
        List<Integer> listOfInteger = new ArrayList<Integer>();

        for (String s : givenNumber) {
            listOfInteger.add(Integer.parseInt(s));
        }

        listOfInteger.sort((a, b) -> {
            if (a.equals(b))
                return 0;
            else if (compareTwoNumber(a, b))
                return -1;
            else
                return 1;
        });

        StringBuilder res = new StringBuilder();
        for (int i : listOfInteger) {
            res.append(i);
        }
        return res.toString();
    }

    static int concat2Integers(int a, int b)
    {

        String s1 = Integer.toString(a);
        String s2 = Integer.toString(b);

        String s = s1 + s2;

        return Integer.parseInt(s);
    }

    private static boolean compareTwoNumber(int a, int b) {
        return concat2Integers(a, b) > concat2Integers(b, a);
    }

    private static int getFirstDigit (int n) {
        while (n >= 10)
            n /= 10;

        return n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

