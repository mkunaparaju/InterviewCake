package Arrays_Strings.main;

public class SingleRiffleShuffle {
    public static void main(String[] args) {
        int [] shuffled = {1,2,3,4,5,6,7,8,9,10};
        int [] half1 = {1,3,5,7,9};
        int [] half2 = {2,4,6,8,10};

        boolean isShuffled = isShuffled(shuffled, half1, half1);
        System.out.println(isShuffled);
    }
//wrong implemetntaiton
    private static boolean isShuffled(int[] shuffled, int[] half1, int[] half2) {
        int index = 0;
        int p1 = 0;
        int p2 = 0;

        while(index < shuffled.length){
            if(shuffled[index] != half1[p1]){
                if(shuffled[index] != half2[p2]){
                    return false;
                }
                else{
                    p2++;
                    index++;
                }
            }
            else {
                p1++;
                index++;
            }
        }
        return true;
    }
}
