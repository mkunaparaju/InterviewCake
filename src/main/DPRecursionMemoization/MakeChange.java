package main.DPRecursionMemoization;

import java.util.Arrays;
import java.util.HashMap;

public class MakeChange {

    static HashMap<String , Integer > memoMap = new HashMap<>();

    public static void main(String[] args) {
        int [] denoms = {1,5,10, 25};
        int [] cache = new int[50];
        Arrays.fill(cache, -1);
//        System.out.println(makeChangeRecursive(49, denoms));
//        System.out.println(makeChangeMemoization(49, denoms, cache));
        System.out.println(makeChangeTopDown(49,denoms));
    }

    private static int makeChangeTopDown(int amount, int[] denoms) {
       int  [] cache = new int [amount+1];
       for(int i = 1; i <= amount; i++){
           int min = Integer.MAX_VALUE;
           for(int coin : denoms){
               if(i - coin >= 0  ){
                   int ways = cache[i-coin];
                   min = ways< min ? ways:min;
               }
           }
           cache[i] = min+1;
       }
        return cache[amount];



//
//        public int makeChange(int c) {
//            int[] cache = new int[c + 1];
//            for (int i = 1; i <= c; i++) {
//                int minCoins = Integer.MAX_VALUE;
//// Try removing each coin from the total
//// and see which requires the fewest
//// extra coins
//                for (int coin : coins) {
//                    if (i - coin >= 0) {
//                        int currCoins = cache[i-coin] + 1;
//                        if (currCoins < minCoins) {
//                            minCoins = currCoins;
//                        }
//                    }
//                }
//                cache[i] = minCoins;
//            }
//            return cache[c];
    }

    private static int makeChangeRecursive(int amount, int[] denoms) {
        int minCoins = Integer.MAX_VALUE;
        if(amount == 0) return 0;

        for(int denom : denoms){
            if(amount - denom >= 0) {
                int coins = makeChangeRecursive(amount - denom, denoms);
                minCoins = minCoins > coins ? coins : minCoins;
            }
        }
        return minCoins+1;
    }

    private static int makeChangeMemoization(int amount, int[] denominations, int[] cache){

        if(amount == 0 ) return 0;
        int min = Integer.MAX_VALUE;
        if(cache[amount] != -1) return cache[amount];

        for(int coin : denominations){
            if(amount - coin >= 0){
                int ways = makeChangeMemoization(amount - coin, denominations, cache);
                if(ways < min) min = ways;
            }
        }
        cache[amount] = min+1;
        return min+1;
    }



}
