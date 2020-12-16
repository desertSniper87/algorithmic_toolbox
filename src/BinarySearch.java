import java.io.*;
import java.util.*;

public class BinarySearch {

    static int binarySearch(int[] a, int x) {
        int low = 0, high = a.length;
        int mid;

//        System.out.println("x = " + x);
//        System.out.println("a = " + Arrays.toString(a));


        while (low < high) {
            mid = low + Math.floorDiv((high - low), 2);
//            System.out.println("low = " + low);
//            System.out.println("high = " + high);
//            System.out.println("mid = " + mid);
//
//            System.out.println("a[mid] = " + a[mid]);
//            System.out.println("x = " + x);
            if (x == a[mid])
                return mid;
            else if (x < a[mid])
                high = mid;
            else
                low = mid + 1;
        }

        return -1;
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            // Input 5 1 5 8 12 13 5 8 1 23 1 11
            // Output 2 0 -1 0 -1
            // Input 5 1 2 3 4 5 5 1 2 3 4 5
            System.out.print(binarySearch(a, b[i]) + " ");
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
