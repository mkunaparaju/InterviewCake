package main.Arrays_Strings;

import main.PrintingHelper;

public class ReverseWordsInPlace {
    public static void main(String[] args) {
        PrintingHelper printingHelper = new PrintingHelper();
        char[] message = { 'c', 'a', 'k', 'e', ' ',
                'p', 'o', 'u', 'n', 'd', ' ',
                's', 't', 'e', 'a', 'l' };

        ReverseWordsInPlace reverse = new ReverseWordsInPlace();
        message = reverse.reverseAllLetters(message, 0, message.length - 1);
        printingHelper.printArray(message);

        message = reverse.reverseWords(message);
        printingHelper.printArray(message);

    }

    //think about the last words and letters. Edge cases
    private char[] reverseWords(char[] message) {
        int p1 = 0;
        int index = 0;
        while(index < message.length){
            if(message[index] == ' '){
                System.out.println(index);
                message = reverseAllLetters(message, p1, index - 1 );
                p1 = index+1;
            }
            if (index == message.length -1){
                message = reverseAllLetters(message, p1, index );
            }
            index++;
        }
        return message;
    }

    private char[] reverseAllLetters(char[] message, int left, int right) {
        //swap all letters
        while(left <= right){
          //  System.out.println("left " + left + " right " + right);
            char temp = message[left];
            message[left] = message[right];
            message[right] = temp;

            left++;
            right--;
        }
        return message;
    }
}
