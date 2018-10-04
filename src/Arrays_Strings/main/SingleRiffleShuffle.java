package Arrays_Strings.main;

public class SingleRiffleShuffle {
    public static void main(String[] args) {
        int [] shuffled = {1,2,3,4,5,6,7,8,9};
        int [] half1 = {1,3,5,7,9};
        int [] half2 = {2,4,6,8};

        boolean isShuffled = isShuffledSingleRiffle(shuffled, half1, half2);
        System.out.println(isShuffled);
    }
//correct implemetntaiton
    private static boolean isShuffledSingleRiffle(int[] shuffled, int[] half1, int[] half2) {
     int p1 = 0, p2 = 0, index =0;
     while(index < shuffled.length){
         if(p1 == half1.length){
             if(shuffled[index] == half2[p2]) p2++;
             else return false;
         }
         else if(p2 == half2.length){
             if(shuffled[index] == half1[p1]) p1++;
             else return false;
         }
         else if (shuffled[index] == half1[p1]) p1++;
         else if (shuffled[index] == half2[p2]) p2++;
         else return false;

         index++;
     }
        return true;
    }

    //alt implemntation
    public static boolean isSingleRiffle(int[] half1, int[] half2, int[] shuffledDeck) {
        int half1Index = 0;
        int half2Index = 0;

        for (int card : shuffledDeck) {

            // if we still have cards in half1
            // and the "top" card in half1 is the same
            // as the top card in shuffledDeck
            if (half1Index < half1.length && card == half1[half1Index]) {
                half1Index++;

                // if we still have cards in half2
                // and the "top" card in half2 is the same
                // as the top card in shuffledDeck
            } else if (half2Index < half2.length && card == half2[half2Index]) {
                half2Index++;

                // if the top card in shuffledDeck doesn't match the top
                // card in half1 or half2, this isn't a single riffle.
            } else {
                return false;
            }
        }

        // all cards in shuffledDeck have been "accounted for"
        // so this is a single riffle!
        return true;
    }


}
