package main.Pramp;

public class RootOfNumber {

    public static void main(String[] args) {
        int x1 = 7, n1 = 3;

        int x2 = 9, n2 = 2;

        System.out.println(root(x1,n1));
        System.out.println(root(x2,n2));
    }

    static double root(double x, int n) {
        if(x == 0) return 0;

        double low = 0;
        double upper = (x>1) ? x : 1;

        double approxRoot = (low + upper) /2 ;

        while(Math.abs(approxRoot - low) >= .001){
            if (Math.pow(approxRoot, n) > x) upper = approxRoot;

            else if (Math.pow(approxRoot, n) < x) low = approxRoot;
        else
            break;

        approxRoot = (upper + low) / 2;
        }

        return approxRoot;
    }

}
