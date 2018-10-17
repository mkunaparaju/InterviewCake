package main.GreedyAlgorithms;

public class AppleStocks {
    public static void main(String[] args) {
    int [] stocks = {10,7,5,8,11,9};
    int [] stocks2 = {10,7,5,8,11,9,3};
    int [] stocks3 = {10,7,5,8,11,9,3,20};
    int [] stocks4 = {10,7,5};

        System.out.println(getProfit(stocks4));
    }

    private static int getProfit(int[] stocks) {
        int bp = Integer.MAX_VALUE;
        int sp = Integer.MIN_VALUE;
        int spi = -1, bpi = -1;
        int profit = Integer.MIN_VALUE;



        for( int i = 0; i < stocks.length; i++){
            if(stocks[i] < bp) {
                bp = stocks[i];
                bpi = i;
            }

            if(stocks[i] > sp && i > bpi){
                sp = stocks[i];
                spi = i;
            }
            if(spi > bpi) profit = ((sp- bp) > profit)? sp-bp :  profit;

            System.out.println("sp " + sp  + " bp " + bp + " profit " + profit);
        }
        return profit;

    }

    static int getProfitAlternate(int [] stocks){
        int minPrice = stocks[0];
        int maxProfit = stocks[1] - stocks[0];

        for(int i = 1 ; i < stocks.length; i++){
            int currentPrice = stocks[i];
            int possibleProfit = currentPrice - minPrice;
            maxProfit = Math.max(possibleProfit, maxProfit);
            minPrice = Math.min(minPrice, currentPrice);
        }

        return maxProfit;
    }


}
