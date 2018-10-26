package main.DPRecursionMemoization;

public class FibonacciIterative {

    public static void main(String[] args) {
        int n = 8;
        System.out.println(fib(n));
    }

    private static int fib(int n) {
        if(n==0 || n ==1) return n;

        int current = 1;
        int temp = 0 ;
        int prev = 0;

        for(int i = 1; i < n; i++ ){
            temp = current;
            current = temp+prev;
            prev = temp;
        }
        return current;
    }
}
