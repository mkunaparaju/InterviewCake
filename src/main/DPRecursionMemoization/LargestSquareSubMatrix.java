package main.DPRecursionMemoization;

public class LargestSquareSubMatrix {
    public static void main(String[] args) {
        boolean [][] arr = {{true,true,true,true,true},{true, true,true,true,false},{true, true,true,true,false} ,{true, true,true,true,false} ,{true, false, false, false, false}};

        System.out.println(squareSubmatrix(arr));
    }

    private static int squareSubmatrix(boolean[][] arr) {
        int max = 0;
        for(int i = 0 ; i < arr.length; i++){
            for (int j = 0 ; j < arr[0].length; j++ ){
                if(arr[i][j]){
                    max = Math.max(max, squareSubmatrix(arr, i , j));
                }
            }
        }
        return max;

    }

    private static int squareSubmatrix(boolean[][] arr, int i, int j) {
        if(i == arr.length || j == arr[0].length)return 0;
        if(!arr[i][j]) return 0;

        return 1 + Math.min(Math.min(squareSubmatrix(arr, i+1, j), squareSubmatrix(arr, i , j +1)), squareSubmatrix(arr, i+1, j+1));
    }
}
