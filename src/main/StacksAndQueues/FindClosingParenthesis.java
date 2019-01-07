package main.StacksAndQueues;

import javax.sound.midi.Soundbank;

public class FindClosingParenthesis {

    public static void main(String[] args) {

        String in = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
        int inParen = 10;
        System.out.println(getCloseParen(in, inParen));
    }

    static int getCloseParen(String in, int inParen){
        int openIndex = 0;
        int pos = -1;
        for(int i =inParen+1 ; i < in.length(); i ++) {
            if(in.charAt(i) == '('){
                openIndex++;
            }
            else if(in.charAt(i) == ')'){
                if(openIndex == 0) pos = i;
                openIndex--;
            }
        }


        if(pos == -1) throw new IllegalArgumentException("no closing parenthesis");
        return pos;
    }
}
