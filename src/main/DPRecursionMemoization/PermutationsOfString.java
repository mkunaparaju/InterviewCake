package main.DPRecursionMemoization;

import java.util.Collections;
import java.util.HashSet;

public class PermutationsOfString {

    public static void main(String[] args) {
        String in = "cats";
        HashSet<String> permSet = getPermutations(in);
        for(String perms : permSet){
            System.out.println(perms);
        }
    }

    private static HashSet<String> getPermutations(String in) {
        //base case when input is just one letter
        if(in.length() <= 1 ){
            return new HashSet<>(Collections.singletonList(in));
        }

        String allExceptLast = in.substring(0, in.length()-1);
        char lastLetter = in.charAt(in.length() - 1);

        HashSet<String> permOfNotLastLetter = getPermutations(allExceptLast);
        HashSet<String> permSet = new HashSet();

        for(String perm : permOfNotLastLetter){
            for(int i = 0 ; i <= allExceptLast.length(); i++){
                String newPerm = perm.substring(0, i) + lastLetter + perm.substring(i);
                permSet.add(newPerm);
            }
        }
        return permSet;
    }
}
