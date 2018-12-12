package main.GreedyAlgorithms;

public class AppleStocksRound2 {
    public static void main(String[] args) {
        int [] stocks = {10,7,5,8,11,9};
        int [] stocks2 = {10,7,5,8,11,9,3};
        int [] stocks3 = {10,7,5,8,11,9,3,20};
        int [] stocks4 = {10,7,5};

        System.out.println(getProfit(stocks2));
    }

    private static int getProfit(int[] stocks) {
        int p1 = 0;
        int p2 = 0;
        int minVal = stocks[0];
        int maxDiff = 0;

        while(p2 < stocks.length - 1){
            p2++;
            if(stocks[p2] < stocks[p1]) {
                minVal = stocks[p2];
                p1 = p2;
            }else{
                    maxDiff = Math.max(stocks[p2] - stocks[p1],maxDiff);
                }
            }
            return maxDiff;
        }
    }
