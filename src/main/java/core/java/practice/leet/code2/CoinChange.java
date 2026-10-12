package core.java.practice.leet.code2;

import java.util.Arrays;

public class CoinChange {

    private static boolean canMakeAmount(int[] minCoins, int i, int coin) {
        return minCoins[i - coin] != Integer.MAX_VALUE;
    }

    private static boolean isAmountReachable(int i, int coin) {
        return i - coin < 0;
    }

    public int coinChange(int[] coins, int amount) {
        int[] minCoins = new int[amount + 1];
        Arrays.fill(minCoins, Integer.MAX_VALUE);
        minCoins[0] = 0; // base case: 0 amount requires 0 coins
        Arrays.sort(coins);

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (isAmountReachable(i, coin)) break;
                if (canMakeAmount(minCoins, i, coin)) {
                    minCoins[i] = Math.min(minCoins[i], minCoins[i - coin] + 1);
                }
            }
        }

        return minCoins[amount] == Integer.MAX_VALUE ? -1 : minCoins[amount];
    }
}
