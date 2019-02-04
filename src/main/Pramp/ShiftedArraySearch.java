package main.Pramp;

public class ShiftedArraySearch {
    public static void main(String[] args) {
        int [] shiftArr = {9, 12, 17, 2, 4, 5};
        int num = 2;

        System.out.println(shiftedArrSearch(shiftArr, num));
    }

    static int shiftedArrSearch(int[] shiftArr, int num) {
        int start = 0;
        int end = shiftArr.length - 1;
        int mid = (start - end)/2;
        int pivot = 0;

        while(start < end){
             if(shiftArr[mid] > shiftArr[mid+1]) {
                pivot = mid+1;
                break;
            }else  if(shiftArr[mid-1] > shiftArr[mid]){
                pivot = mid;
                break;
            }

            if(shiftArr[start] < shiftArr[mid]) {
                start = mid;
                mid = (end - start) /2;
            }else{
                end = mid;
                mid = (end - start)/2;
            }
        }

        int index = 0;

        if(num > shiftArr[pivot] && num <= shiftArr[end]) return bs(pivot, shiftArr.length-1, shiftArr, num);
        else return bs(0, pivot, shiftArr, num);

    }

    private static int bs(int start, int end, int[] shiftArr, int num) {
        int mid = (end - start )/2;

        while (start < end){

            if( shiftArr[mid] == num) return mid;
            if(shiftArr[mid] < num ) {
                start = mid;
            }else end = mid;

            mid = (end - start) /2;
        }
        return mid;
    }
}
