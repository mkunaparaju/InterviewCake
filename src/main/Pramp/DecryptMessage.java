package main.Pramp;

public class DecryptMessage {
    static String decrypt(String word) {
        if(word.length() == 0) return word;

        char firstLetter = word.charAt(0);
        char firstOriginalLetter = (char)(firstLetter -1) ;
        String original = firstOriginalLetter + "";

        char valAtStep2 = word.charAt(0);

        for(int i = 1; i < word.length(); i++ ){
            int valOfMultiple = (word.charAt(i) - valAtStep2);
            System.out.println(" valOfMultiple " + valOfMultiple) ;
            while(valOfMultiple <= 122){
                valOfMultiple = (valOfMultiple + 26);
                //ystem.out.println(" valOfMultiple " + (int)valOfMultiple) ;
                if(valOfMultiple >= 97) break;
            }
            original = original + (charrr)(valOfMultiple);
            System.out.println("valsAtStep2 " + (int)valAtStep2 + " valOfMultiple " + (int)valOfMultiple) ;
            valAtStep2 = (char)(valOfMultiple + valAtStep2);

        }
        return original;
    }

    public static void main(String[] args) {
        String word = "dnotq";

        System.out.println(decrypt(word));
    }
}
