package main.GreedyAlgorithms;

public class AppleStocksRound3 {
    public static void main(String[] args) {
    int [] stocks = {10,7,5,8,11,9};
    int [] stocks2 = {10,7,5,8,11,9,3};
    int [] stocks3 = {10,7,5,8,11,9,3,20};
    int [] stocks4 = {10,7,5};

        System.out.println(getProfit(stocks2));
    }

    private static int getProfit(int[] stocks) {
        int maxProfit = Integer.MIN_VALUE;
        int minStock = Integer.MAX_VALUE;

        for(int stock: stocks){
            if(stock < minStock) minStock = stock;
            if(stock - minStock > maxProfit) maxProfit = stock - minStock;
        }

        return maxProfit;
    }

}
