package main.HashMapImplementation;


//Bonus
//What if we wanted the movie lengths to sum to something close to the flight length (say, within 20 minutes)?
//What if we wanted to fill the flight length as nicely as possible with any number of movies (not just 2)?
//What if we knew that movieLengths was sorted? Could we save some space and/or time?

//https://www.interviewcake.com/question/java/inflight-entertainment?course=fc1&section=hashing-and-hash-tables

import java.util.HashSet;

//Solve for these in Round 2
public class InFlightBonus {
    public static void main(String[] args) {
        int flightTime = 120;
        int [] mLength = {30, 90,42};

        System.out.println(areMoviesAvailable(flightTime, mLength));

    }

    private static boolean areMoviesAvailable(int flightTime, int[] mLength) {
        HashSet<Integer> complement =new HashSet<>();

        for(int movie : mLength){
            //checking to see if second movie exists
            if(complement.contains(movie)){
                return true;
            }
            //adding complement of that movie which is second movie
            else{
                complement.add(flightTime - movie);
            }
        }

        return false;
    }
}
