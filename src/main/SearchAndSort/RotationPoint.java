package main.SearchAndSort;

public class RotationPoint {

    public static void main(String[] args) {
        String[] a1 = {"p", "r", "s", "a", "ba", "bb", "e", "k", "o"};
        String[] a2 = {"k", "v", "a", "b", "c", "d", "e", "g", "i"};
        String[] a3 = {"a", "b", "c", "d"};

        //  int rotationPoint = findRotationPointIterative(0, a3.length -1, a3, 0);
        int ro2 = findRotationPointRecursive(0, a2.length - 1, a2, 0);
        //System.out.println(rotationPoint);
        System.out.println(ro2);
    }

    private static int findRotationPointRecursive(int floor, int ceiling, String[] a, int begin) {
        if (floor >= ceiling) return floor;

        int middle = ((ceiling - floor) / 2) + floor;

        if (a[middle + 1].compareTo(a[middle]) < 0) return middle + 1;

        if (a[begin].compareTo(a[middle]) >= 0) {
            return findRotationPointRecursive(floor, middle - 1, a, begin);
        }

        int minOfSecond = findRotationPointRecursive(middle, ceiling, a, middle);
        if (a[begin].compareTo(a[minOfSecond]) <= 0) return begin;
        else return minOfSecond;
    }

    private static int findRotationPointIterative(int floor, int ceiling, String[] a, int begin) {
        int middle = 0;
        while (floor < ceiling) {

            System.out.println("middle " + middle + " cei " + ceiling + " flo " + floor);
            if (floor + 1 == ceiling) break;


            middle = ((ceiling - floor) / 2) + floor;

            if (a[middle].compareTo(a[begin]) >= 0) {
                floor = middle;
            } else {

                ceiling = middle;
            }

        }

        return (a[begin].compareTo(a[ceiling]) < 0) ? begin : ceiling;
    }


}
