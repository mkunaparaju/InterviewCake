package main.SearchAndSort;

import main.PrintingHelper;

public class TopScores {

    public static void main(String[] args) {
        int[] unsorted = {37, 89, 91, 65, 91, 53};
        int highest = 100;

        PrintingHelper printingHelper = new PrintingHelper();
        printingHelper.printArray(getSorted(unsorted, highest));
    }

    private static int[] getSorted(int[] unsorted, int highest) {
        int[] countArray = new int[highest + 1];
        int[] sorted = new int[unsorted.length];
        int indexOfSorted = 0;
        for (int i : unsorted) {
            countArray[i]++;
        }

        for (int i = 0; i < countArray.length; i++) {
            if (countArray[i] != 0) {
                for (int j = 0; j < countArray[i]; j++) {
                    sorted[indexOfSorted] = i;
                    indexOfSorted++;
                }
            }
        }
        return sorted;
    }
}
