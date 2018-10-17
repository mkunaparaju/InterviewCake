package main.GreedyAlgorithms;

import main.PrintingHelper;

import java.util.Random;

public class InPlaceShuffle {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12};
        PrintingHelper printingHelper = new PrintingHelper();
        printingHelper.printArray(inPlaceShuffle(arr));
    }

    private static int[] inPlaceShuffle(int[] arr) {
        if (arr.length < 1) throw new IllegalArgumentException("cannot shuffle array with only one element");
        for (int i = 0 ; i < arr.length - 1; i ++)   {
            int temp = arr[i];
            int randIndex = getRandom(i+1, arr.length -1 );
            arr[i] = arr[randIndex];
            arr[randIndex] = temp;
        }
        return arr;

    }

    private static int getRandom(int i, int length) {
        Random random = new Random();
        int rand = random.nextInt(length - i + 1) + i;

        return rand;
    }
}
