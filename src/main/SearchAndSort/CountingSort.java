package main.SearchAndSort;

import main.PrintingHelper;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        PrintingHelper printingHelper = new PrintingHelper();
//        printingHelper.printArray(countingSortWArray(arr, 10));
        printingHelper.printArray(countingSortRound2(arr, 10));

    }

    private static int[] countingSortWArray(int[] arr, int maxVal) {
        int[] sortedArray = new int[arr.length];
        int count[] = new int[arr.length + 1];

        for (int num : arr) {
            count[num]++;
        }

        int currentSortedIndex = 0;
        for (int num = 0; num < count.length; num++) {
            int counts = count[num];

            // for the number of times the item occurs
            for (int i = 0; i < counts; i++) {

                // add it to the sorted array
                sortedArray[currentSortedIndex] = num;
                currentSortedIndex++;
            }
        }
        return sortedArray;
    }

    static int[] countingSortRound2(int[] a, int maxVal) {
        int[] countArr = new int[maxVal + 1];

        for (int i : a) {
//            System.out.println(i);
            if (countArr[i] != 0) {
                int score = countArr[i];
                countArr[i] = score + 1;
            } else {
                countArr[i] = 1;
            }
        }
//        int i = 0;
        int p = 0;

        for (int i = 0; i < countArr.length; i++) {

            if (countArr[i] != 0) {

                for (int count = 0; count < countArr[i]; count++) {
                    a[p] = i;
                    p++;
                }
            }
        }
        return a;
    }
}
