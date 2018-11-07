package main.DPRecursionMemoization;


public class LargestSquareSubMatrix {
    static int [][] cache;

    public static void main(String[] args) {
        boolean [][] arr = {{true,true,true,true,true},{true, true,true,true,false},{true, true,true,true,false} ,{true, true,true,true,false} ,{true, false, false, false, false}};
        cache = new int [arr.length][arr[0].length];
//        System.out.println(squareSubmatrix(arr));
        System.out.println(bottomUpSquareSubmatrix(arr));
    }

    private static int squareSubmatrix(boolean[][] arr) {
        int max = 0;
        for(int i = 0 ; i < arr.length; i++){
            for (int j = 0 ; j < arr[0].length; j++ ){
                if(arr[i][j]){
//                    max = Math.max(max, squareSubmatrix(arr, i , j));
                    max = Math.max(max, cacheSquareSubmatrix(arr, i , j));
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

    private static int cacheSquareSubmatrix(boolean[][] arr, int i, int j){

        if(i == arr.length || j == arr[0].length)return 0;
        if(!arr[i][j]) return 0;
        if(cache[i][j] > 0) return cache[i][j];
        return 1 + Math.min(Math.min(squareSubmatrix(arr, i+1, j), squareSubmatrix(arr, i , j +1)), squareSubmatrix(arr, i+1, j+1));

    }

    private static  int bottomUpSquareSubmatrix(boolean [][] arr){
        int max = 0;
        for(int i = 0; i < arr.length; i ++){
            for(int j = 0; j < arr[0].length; j ++){
                if(i == 0 || j == 0) cache[i][j] = arr[i][j] ? 1:0;
                else if(arr[i][j]) {
                    cache[i][j] = 1 + Math.min(Math.min((cache[i-1][j]), cache[i][j-1]), cache[i-1][j-1]);
                }
               if(cache[i][j] > max) max = cache[i][j];
            }
        }

        return max;
    }
}
