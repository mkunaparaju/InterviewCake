package main.Pramp;

public class Round1 {
    static double binarySearch(double st,double end,double x,int n){

        if(Math.abs(end - st) <(1/1000)) {
            return end;
        }

        double mid = st +(end -st)/2;
        double nthrootofmid = Math.pow(mid,n);
        System.out.println("mid" + mid);

        if(nthrootofmid == x) return mid;

        if(nthrootofmid > x){
            return  binarySearch(st,mid,x,n);
        }
        else{
            return  binarySearch(mid,end,x,n);
        }
    }
    static double root(double x, int n) {
        // your code goes here
        if(x == 0){
            return 0;
        }

        double st = 0;
        double end = x;

        double val = binarySearch(st,end,x,n);
        return val;

    }

    public static void main(String[] args) {
        double res =  root(7,3);
        System.out.println(res);
    }

}


/*
  function deletionDistance(str1, str2):
    str1Len = str1.length
    str2Len = str2.length

    # allocate a 2D array with str1Len + 1 rows and str2Len + 1 columns
    memo = new Array(str1Len + 1, str2Len + 1)

    for i from 0 to str1Len:
        for j from 0 to str2Len:
            if (i == 0):
                memo[i][j] = j
            else if (j == 0):
                memo[i][j] = i
            else if (str1[i-1] == str2[j-1]):
                memo[i][j] = memo[i-1][j-1]
            else:
                memo[i][j] = 1 + min(memo[i-1][j], memo[i][j-1])

    return memo[str1Len][str2Len]
*/
