package main.DPRecursionMemoization;

import java.lang.management.ManagementFactory;
import java.util.HashMap;

public class KnapsackProblem {
    static HashMap<String, Integer> memoMap = new HashMap<>();

    public static void main(String[] args) {
        Item i1 = new Item(2,6);
        Item i2 = new Item(2,10);
        Item i3 = new Item(3,12);

        Item [] items = {i1,i2,i3};

        System.out.println(getMaxValue(items, 5));

    }

    private static int getMaxValue(Item[] items, int maxWt) {
       // return getMaxValueBrute(items,maxWt, 0);
//        return getMaxValueMemoization(items,maxWt, 0);
        return getMaxValueTopDown(items, maxWt);
    }

    private static int getMaxValueBrute(Item[] items, int maxWt, int i) {

        if(i == items.length) return 0;
        if(maxWt - items[i].getWeight() < 0) return getMaxValueBrute(items, maxWt, i+1);

        return Math.max((getMaxValueBrute(items, maxWt - items[i].getWeight(), i+1) + items[i].getValue()),  getMaxValueBrute(items, maxWt, i+1));
    }

    private static int getMaxValueMemoization(Item[] items, int maxWt, int i){
        if(i == items.length) return 0;
        String keyToGet = maxWt + " " + i;
        String keyToPut;
        int toReturn;
        if(memoMap.containsKey(keyToGet)) return memoMap.get(keyToGet);
        if(maxWt - items[i].getWeight() < 0){
            toReturn = getMaxValueMemoization(items, maxWt, i+1);
            keyToPut = maxWt + " " + (i+1);
        }
        else{
            toReturn = Math.max((getMaxValueBrute(items, maxWt - items[i].getWeight(), i+1) + items[i].getValue()),  getMaxValueBrute(items, maxWt, i+1));
            keyToPut = (maxWt - items[i].getWeight()) + " " + (i+1);
        }
        System.out.println("key " + keyToPut );
        memoMap.put(keyToPut, toReturn);
        return toReturn;

    }

    private static int getMaxValueTopDown(Item [] items, int maxWt){
        int [][] cache = new int [items.length + 1][ maxWt + 1];
        for (int i = 1 ; i <= items.length ; i ++){
            for (int j = 0; j <= maxWt; j ++){
                if(j < items[i-1].getWeight()) cache[i][j] = cache[i-1][j];
                else{
                    cache[i][j] = Math.max(cache[i-1][j-items[i-1].getWeight()] + items[i-1].getValue(), cache[i-1][j]);
                }
            }

        }
        return cache[items.length][maxWt];
    }
}

class Item{
    final int weight;
    final int value;

    Item(int weight, int value){
        this.weight = weight;
        this.value = value;
    }


    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }
}
