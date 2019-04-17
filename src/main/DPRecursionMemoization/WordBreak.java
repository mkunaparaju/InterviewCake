package main.DPRecursionMemoization;

//https://www.geeksforgeeks.org/word-break-problem-dp-32/

import java.util.*;

public class WordBreak {
    static HashMap<String, Boolean> wordMap = new HashMap<>();

    public static void main(String[] args) {
        String[] dictionary = {"i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "icecream", "man", "go", "mango"};
        List<String> dict = Arrays.asList(dictionary);
        String in1 = "ilike";
        String in2 = "ilikesamsung";
        String in3 = "samsungicecreammangocecreamman";

        System.out.println(canBeSplit(dict, in3));

    }

    private static boolean canBeSplit(List<String> dictionary, String in) {
        if (dictionary.contains(in)) return true;
        if(wordMap.containsKey(in)) return wordMap.get(in);
        System.out.println(in);

        boolean split = false;
        boolean contains = false;

        for (int i = 0; i < in.length(); i++) {
            System.out.println(in.substring(0, i+1));
            contains = dictionary.contains(in.substring(0, i+1));
            if(contains) {
                System.out.println(i);
                System.out.println(in.substring(i+1, in.length()));
                split = canBeSplit(dictionary, in.substring(i+1, in.length()));
                wordMap.put(in.substring(i+1,in.length()), split);
            }
            if(contains&&split) return true;
        }

        return contains && split;
    }
}
