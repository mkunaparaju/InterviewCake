package main.SearchAndSort;

public class RotationPointRound2 {

    public static void main(String[] args) {
        String[] a1 = {"p", "r", "s", "a", "ba", "bb", "e", "k", "o"};
        String[] a2 = {"k", "v", "a", "b", "c", "d", "e", "g", "i"};
        String[] a3 = {"a", "b", "c", "d"};

        //  int rotationPoint = findRotationPointIterative(0, a3.length -1, a3, 0);
        int ro2 = findRotationPointIterative(0, a2.length - 1, a2, 0);
        //System.out.println(rotationPoint);
        System.out.println(ro2);
    }

    private static int findRotationPointIterative(int start, int end, String[] a, int i) {
        int mid = (start + end) /2;
        while (start < end){
            if(a[mid].compareToIgnoreCase(a[start]) < 0){
                end = mid;
            }
            else {
                start = mid + 1;
            }
            mid = (start+end)/2;
        }
        return mid;
    }

    private static int findRotationPointRecursive(int start, int end, String[] arr, int i) {

        return 0;
    }
}
