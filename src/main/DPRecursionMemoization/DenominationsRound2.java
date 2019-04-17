package main.DPRecursionMemoization;

import java.util.HashMap;

public class DenominationsRound2 {

    HashMap<String, Integer> wayMap = new HashMap<>();

    public static void main(String[] args) {

        int[] denom = {1, 2, 3};
        DenominationsRound2 denominations = new DenominationsRound2();
        int ways = denominations.getWays(denom, 4, 0);

        System.out.println(ways);
    }

    int getWays(int[] denom, int amount, int index) {
        if (amount == 0) return 1;
        if (amount < 0) return 0;
        if (index >= denom.length) return 0;

        int ways = 0;
        int coin = denom[index];
//
        while (amount >= 0) {
            ways += getWays(denom, amount, index + 1);
            amount = amount - coin;
        }
        return ways;
    }

    int getWaysBottomUp(int denom[], int amount) {

        int waysNCents[] = new int[denom.length + 1];
        waysNCents[0] = 1;
        for (int coin : denom) {

            for (int higherAmount = coin; higherAmount < denom.length; higherAmount++) {
                int amtRem = higherAmount - coin;
                waysNCents[higherAmount] += waysNCents[amtRem];
            }
        }
        return waysNCents[amount];
    }

}

