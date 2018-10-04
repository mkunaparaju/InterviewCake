package main.Arrays_Strings;

import main.PrintingHelper;

public class ReverseStringInPlace {

    public static void main(String[] args) {
        char [] input = "hello".toCharArray();
        PrintingHelper printingHelper = new PrintingHelper();
        ReverseStringInPlace r = new ReverseStringInPlace();
        printingHelper.printArray(r.reverseInPlace(input));

    }

    char[] reverseInPlace(char [] input){
        int left = 0;
        int right = input.length - 1;

        while (left != right){

            //swap elements
            char temp = input[left];
            input[left] = input [right];
            input[right] = temp;

            left++;
            right--;
        }
        return input;
    }
}
