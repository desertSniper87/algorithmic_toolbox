import java.util.Arrays;
import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int[] coins, int target) {
        int[] minNumberOfCoins = new int[target+1];
        final int INF = Integer.MAX_VALUE;

        Arrays.fill(minNumberOfCoins, 0);

        for (int money = 1; money <= target; money++) {
            minNumberOfCoins[money] = INF;
            for (int coin: coins) {
                if (coin <= money) {
                    int numberOfCoins = minNumberOfCoins[money-coin] + 1;
                    if (numberOfCoins < minNumberOfCoins[money]) {
                        minNumberOfCoins[money] = numberOfCoins;
                    }
                }
            }
        }

        return minNumberOfCoins[target];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] coins = new int[]{1, 3, 4};
        System.out.println(getChange(coins, m));
    }
}

