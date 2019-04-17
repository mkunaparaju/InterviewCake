package main.StacksAndQueues;

public class FindClosingParenthesisRound2 {

    public static void main(String[] args) {

        String in = "Sometimes (when) I nest them (my parentheticals) too much (like this (and this)) they get confusing.";
        int inParen = 10;
        System.out.println(getCloseParen(in, inParen));
    }

    static int getCloseParen(String in, int inParen){
        int openBraces = 0;
        for(int i = inParen; i < in.length(); i++ ){

            if(in.charAt(i) == '(') openBraces++;
            if(in.charAt(i) == ')') openBraces--;

            if(openBraces == 0) return i;
        }
        return -1;
    }
}
