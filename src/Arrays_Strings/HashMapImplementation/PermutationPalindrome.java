package Arrays_Strings.HashMapImplementation;

import java.util.*;

public class PermutationPalindrome {

    public static void main(String[] args) {
        String in1 = "civic";
        String in2 = "palin";

        System.out.println(isPalindrome(in2));
    }

    private static boolean isPalindrome(String in) {
        HashMap<String, Integer> letterMap = new HashMap<String, Integer>();
        int count = 0;

        for (int i = 0; i < in.length(); i++) {
            String s = in.substring(i, i + 1);
            if (letterMap.containsKey(s)) {
                int val = letterMap.get(s);
                val++;
                letterMap.put(s, val);
            } else {
                letterMap.put(s, 1);
            }
        }

        Collection c = letterMap.values();
        Iterator<Integer> it = c.iterator();

        while (it.hasNext()) {
            int val = it.next();
            if (val % 2 != 0) count++;
        }

        return (count > 1) ? false : true;

    }

    //alternate implementation

    public static boolean hasPalindromePermutation(String theString) {

        // track characters we've seen an odd number of times
        Set<Character> unpairedCharacters = new HashSet<>();

        for (char c : theString.toCharArray()) {
            if (unpairedCharacters.contains(c)) {
                unpairedCharacters.remove(c);
            } else {
                unpairedCharacters.add(c);
            }
        }

        // the string has a palindrome permutation if it
        // has one or zero characters without a pair
        return unpairedCharacters.size() <= 1;
    }

}

