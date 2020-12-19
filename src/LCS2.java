import java.util.*;

public class LCS2 {
    private static int[] a;
    private static int[] b;

    private static int lcs2(int s1_len, int s2_len) {

        int[][] memo_table = new int[s1_len+1][s2_len+1];

        for (int[] row : memo_table) {
            Arrays.fill(row, 0);
        }

        for (int i = 0; i <= s1_len; i++) {
            for (int j = 0; j <= s2_len; j++) {
                if (i == 0 || j == 0){
                    memo_table[i][j] = 0;
                }
                else if (a[i - 1] == b[j - 1]) {
                    memo_table[i][j] = memo_table[i - 1][j - 1] + 1;
                }
                else {
                    memo_table[i][j] = Math.max(memo_table[i - 1][j], memo_table[i][j - 1]);
                }
            }
        }

        return memo_table[s1_len][s2_len];
    }

    public static void main(String[] args) {
        // Input 3 2 7 5 2 2 5
        // Input 4 2 7 8 3 4 5 2 8 7
        // Input 1 7 4 1 2 3 4

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a.length, b.length));
    }
}

