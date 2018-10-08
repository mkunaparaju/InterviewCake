package main.HashMapImplementation;

import main.PrintingHelper;

public class CountingSort {

    static PrintingHelper printingHelper = new PrintingHelper();

    public static void main(String[] args) {
        int[] array = {89, 89, 89, 63, 91, 53};
        int highest = 100;
        printingHelper.printArray(CountingsortArray(array, highest));
    }

    private static int[] CountingsortArray(int[] array, int highest) {
        int[] countArray = new int[highest + 1];
        int playerCount = 0;
        for (int score : array) countArray[score]++;
        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] != 0) {
                //populate array with players' score inorder
                for (int j = playerCount; j < playerCount + countArray[i]; j++) {
                    System.out.println("playerCount" + playerCount);
                    array[j] = i;
                }
                playerCount += countArray[i];
            }
        }
        return array;
    }
}
