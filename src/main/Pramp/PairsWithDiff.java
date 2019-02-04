package main.Pramp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PairsWithDiff {


    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        HashSet<Integer> xSet = new HashSet<Integer>();

        for(int a : arr){
            xSet.add(a);
        }// o(n)

        List<List<Integer>> output = new ArrayList<List<Integer>>();
        //
        for(int i = 0; i< arr.length; i++){
            int a = arr[i];
            if(xSet.contains(a+k)){
                List<Integer> pair = new ArrayList();
                pair.add(a+k);
                pair.add(a);
                output.add(pair);
            }
        }//o(n)

        int [][] outputArray = new int [output.size()][2];
        for(int i = 0; i < output.size(); i++){

            outputArray[i][0] = output.get(i).get(0);
            outputArray[i][1] = output.get(i).get(1);
        }//(o(n))
        return outputArray;

    }


    //O(N)  /// O(N)
    public static void main(String[] args) {
        int arr [] = {0, -1, -2, 2, 1};

        int out[][] = findPairsWithGivenDifference(arr, 1);

        for(int i = 0; i < out.length; i++){
            for(int j = 0; j < 2; j++){
                System.out.print(out[i][j] + " ") ;
            }
            System.out.println(" ");
        }

    }
}
