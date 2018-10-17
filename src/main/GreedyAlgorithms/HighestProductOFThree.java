package main.GreedyAlgorithms;

public class HighestProductOFThree {
    public static void main(String[] args) {
    int [] array = {10,7,5,8,11,9};
    int [] array2 = {-10,-10, 1, 3, 2};

        System.out.println(getHighestOfThree(array2));
    }

    private static int getHighestOfThree(int[] array) {
        int hp3 = array[0]*array[1]*array[2];
        int hp2 = array[0]*array[1];
        int lp2 = array[0]*array[1];
        int h = Math.max(array[0],array[1]);
        int l = Math.min(array[0], array[1]);

        for( int i = 3; i < array.length; i++){
            int current = array[i];
            hp3 = getMax(hp3, hp2 * current, lp2 * current );
            hp2 = getMax(hp2, h*current, l*current);
            lp2 = getMin(hp2, h*current, l*current);
            h = Math.max(h, current);
            l = Math.min(l , current);
        }
        return hp3;

    }

    private static int getMin(int i1, int i2, int i3) {
        return Math.min(Math.min(i2 ,i3), i1);
    }

    private static int getMax(int i1, int i2, int i3) {
        return Math.max(Math.max(i2 ,i3), i1);

    }

}
