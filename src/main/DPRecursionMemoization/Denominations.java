package main.DPRecursionMemoization;

import java.util.Arrays;
import java.util.HashMap;

public class Denominations {

    HashMap<String, Integer> wayMap = new HashMap<>();
    public static void main(String[] args) {

        int [] denom = {1,2,3};
        Denominations denominations = new Denominations();
        int ways = denominations.getWays(denom, 4, 0);

        System.out.println(ways);
    }

    int getWays(int [] denom, int amount, int index){
        String key = amount+","+index;

        if(wayMap.containsKey(key)){
            return wayMap.get(key);
        }

        if(amount == 0) return 1;
        if(amount < 0) return 0;
        if(index == denom.length) return 0;

        int coin = denom[index];
        int ways = 0;
        while(amount >= 0){

           ways+= getWays( denom,amount, index+1);
            amount = amount - coin;
        }
        wayMap.put(key, ways);
        return ways;
    }

        

}

