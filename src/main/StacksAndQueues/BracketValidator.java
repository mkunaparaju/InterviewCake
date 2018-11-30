package main.StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BracketValidator {

    public static void main(String[] args) {
        String in = "{ [ ] ( ) }";
        String in1 = "{ [ ( ] ) }";

        System.out.println(bracketValidator(in1));
    }

    private static boolean bracketValidator(String in) {
        Deque<Character> s = new ArrayDeque<>();
        char [] charIn = in.toCharArray();
        for(char c : charIn){
            if(c == '(' || c == '{' || c == '['  ) s.push(c);
            if(c == ')' || c == '}' || c == ']'  ) {
                char bracket = s.pop();
                if(c == ')') if(bracket != '(') return false;
                if(c == '}') if(bracket != '{') return false;
                if(c == ']') if(bracket != '[') return false;
            }
        }
        return s.isEmpty();
    }
}
