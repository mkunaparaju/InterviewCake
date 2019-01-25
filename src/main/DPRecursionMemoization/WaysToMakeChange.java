package main.DPRecursionMemoization;

import java.util.HashMap;

public class WaysToMakeChange {

    private static HashMap<String, Integer> memoMap = new HashMap<>();
    public static void main(String[] args) {
        int amt = 4;
        int [] denom = {1,2,3};

        //System.out.println(waysRecursive(amt, denom, 0));
//        System.out.println(waysMemo(amt, denom, 0));
        System.out.println(waysBottomUp(amt, denom));
    }

    static int waysRecursive(int amt, int [] denom, int curIndex){
        int ways = 0;
        if(amt == 0 ) return 1;
        if(amt < 0 || curIndex == denom.length) return 0;

        int curVal = denom[curIndex];
        while(amt>= 0){
            ways = ways + waysRecursive(amt, denom, curIndex+1);
            amt = amt - curVal;
        }

        return ways;
    }

    static int waysMemo(int amt, int [] denom, int curIndex){
        int ways = 0;
        if(amt == 0 ) return 1;
        if(amt < 0 || curIndex == denom.length) return 0;

        String memoKey = amt + " " + curIndex;
        if(memoMap.containsKey(memoKey)) return memoMap.get(memoKey);

        int curVal = denom[curIndex];

        while(amt>= 0){
            ways = ways + waysMemo(amt, denom, curIndex+1);
            amt = amt - curVal;
        }
        memoMap.put(memoKey, ways);
        return ways;
    }

    static int waysBottomUp(int amt, int [] denom){
        int waysI [] = new int [amt+1];
        waysI [0] = 1;

        for(int coin: denom){
            for(int i = 0; i <= amt; i++){
                int remain = i - coin;
                if (remain >= 0){
                    waysI[i] += waysI[remain];
                }
            }
        }

        return waysI[amt];
    }
}
