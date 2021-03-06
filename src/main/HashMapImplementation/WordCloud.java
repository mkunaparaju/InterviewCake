package main.HashMapImplementation;

import main.PrintingHelper;

import java.util.HashMap;
import java.util.List;

public class WordCloud {

    public static void main(String[] args) {
        String input = "After beating the eggs, Dana read the next step: Add milk and eggs, then add flour and sugar.";
        PrintingHelper printingHelper = new PrintingHelper();
        printingHelper.printMap(getWordCloud(input));

    }

    private static HashMap getWordCloud(String input) {
        HashMap<String, Integer> stringMap = new HashMap<>();

        //regex is bad for A GOOD TIME CONSTRAIN. CONSIDER doing your own splitting and parsing.
        input.replaceAll("\\p{Punct}","");
        input.toLowerCase();
        String [] words = input.split(" ");
        for(String word : words){
            if(stringMap.containsKey(word)){
                int val = stringMap.get(word);
                val++;
                stringMap.put(word, val);
            }
            else {
                stringMap.put(word, 1);
            }
        }
        return stringMap;
    }

    private static HashMap<String, Integer> getWordCloud(List<String> sentences){
        HashMap<String,Integer> wordCloud = new HashMap<>();

        for(String sent : sentences){
            String [] words = sent.split(" ");

        }

        return wordCloud;
    }
}
