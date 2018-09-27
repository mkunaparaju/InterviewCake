package Arrays_Strings.main;

public class MergeSortedArray {

    private static PrintingHelper printingHelper = new PrintingHelper();

    public static void main(String[] args) {
        int[] myArray = new int[]{3, 4, 6, 10, 11, 15};
        int[] alicesArray = new int[]{ 12, 14, 19};

        int [] finalArray = mergeSortedArray(myArray, alicesArray);
        printingHelper.printArray(finalArray);
    }

    static int[] mergeSortedArray(int[] myArray, int[] alicesArray) {
        int finalIndex = 0, p1 = 0, p2 = 0;
        int [] merged = new int [myArray.length+alicesArray.length];

        while(finalIndex < myArray.length + alicesArray.length){
           // System.out.println("p1 " + p1 + " p2 " + p2);
            if(p1 >= myArray.length) {
                merged[finalIndex] = alicesArray[p2];
                p2++;
            }

            else if(p2 >= alicesArray.length) {
                merged[finalIndex] = myArray[p1];
                p1++;
            }

            else if(myArray[p1] < alicesArray[p2]){
                merged[finalIndex] = myArray[p1];
                p1++;
            }

            else {
                merged[finalIndex] = alicesArray[p2];
                p2++;
            }
            finalIndex++;
        }
        return merged;
    }
}
