import java.util.*;

class EditDistance {
  public static int getEditDistance(String s, String t) {
    int s_len = s.length() + 1;
    int t_len = t.length() + 1;
    
    int[][] matrix = new int[s_len][t_len];

    for (int i = 0; i < s_len; i++) {
      matrix[i][0] = i;
    }

    for (int i = 0; i < t_len; i++) {
      matrix[0][i] = i;
    }

//    System.out.println("matrix = " + Arrays.deepToString(matrix));

    for (int i = 1; i < s_len; i++) {
      for (int j = 1; j < t_len; j++) {
        if (s.charAt(i-1) == t.charAt(j-1)) {
          matrix[i][j] = Math.min(
                  Math.min(
                    matrix[i-1][j] + 1,
                    matrix[i-1][j-1]
                  ),
                  matrix[i][j-1] + 1
          );
        } else {
          matrix[i][j] = Math.min(
                  matrix[i-1][j] + 1,
                  Math.min(
                          matrix[i-1][j-1] + 1,
                          matrix[i][j-1] + 1
                  )
          );
        }
      }
    }

//    System.out.println("matrix = " + Arrays.deepToString(matrix));

    return matrix[s_len-1][t_len-1];
  }
  public static void main(String[] args) {
    // Input: ab ab

    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(getEditDistance(s, t));
  }

}
