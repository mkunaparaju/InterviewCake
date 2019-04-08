package main.Arrays_Strings;

public class MoveZerosToEnd {

    public static void main(String[] args) {
        int[] arr = {1, 10, 0, 2, 8, 3, 0, 0, 6, 4, 0, 5, 7, 0};
        int[] finalArr = moveZeroToEnd(arr);

        for (int i : finalArr) {
            System.out.print(i + ", ");
        }
    }

    private static int[] moveZeroToEnd(int[] arr) {
        int numberPointer = 0;
        int zeroPointer = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0) {
                zeroPointer = i;
                numberPointer = i;
                while(arr[numberPointer]== 0 && numberPointer < arr.length - 1) {
                    numberPointer++;
                }

                int temp = arr[numberPointer];
                arr[numberPointer] = arr[zeroPointer];
                arr[zeroPointer] = temp;

            }
        }

        return arr;
    }
}
