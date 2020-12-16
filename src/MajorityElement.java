import java.util.*;
import java.io.*;



public class MajorityElement {
    private static int getCount(int[] array, int i) {
        int retCount = 0;
        for (int x : array) {
            if (x == i) {
                retCount ++;
            }
        }

        return retCount;
    }






    private static Integer getMajorityElement(int[] a, int left, int right) {

        System.out.println("left = " + left);
        System.out.println("right = " + right);


        if (left == right) {
            System.out.println("left == right");
            System.out.println("a[left] = " + a[left]);
            return a[left];
        }

        int mid = Math.floorDiv(left + right, 2);

        Integer x = getMajorityElement(a, left, mid);
        Integer y = getMajorityElement(a, mid + 1, right);

        System.out.println("x = " + x);
        System.out.println("y = " + y);


        if (x == null && y == null) {
            System.out.println("x = " + x);
            System.out.println("y = " + y);
            return null;
        }
        else if (x == null) {
            System.out.println("x == null");
            return y;
        }
        else if (y == null){
            System.out.println("y == null");
            return x;
        }
        else if (!x.equals(y)) {
            System.out.println("!x.equals(y)");
            return null;
        }
        else {
            System.out.println("a[x] = " + a[x]);
            return a[x];
        }
    }

    public static void main(String[] args) {
        // Input 5 2 3 9 2 2
        // Input 4 1 2 3 1
        // Input 10 2 124554847 2 941795895 2 2 2 2 792755190 756617003
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        Arrays.sort(a);

        Integer majority = getMajorityElement(a, 0, a.length - 1);
        System.out.println("getCount(a, majority) = " + getCount(a, majority));
        System.out.println("Math.floorDiv(a.length, 2) = " + Math.floorDiv(a.length, 2));
        System.out.println("majority = " + majority);
        if (majority == null) {
             System.out.println(0);
        } else {
            if ((getCount(a, majority)) > Math.floorDiv(a.length, 2)) {
                 System.out.println(1);
            } else
                 System.out.println(0);
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

