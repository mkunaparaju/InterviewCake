package main.HashMapImplementation;

import java.util.*;

public class InFlightEntertainment {

    public static void main(String[] args) {
        int flightTime = 120;
        int [] mLength = {30, 41,42};

        System.out.println(areMoviesAvailable(flightTime, mLength));
    }

    private static boolean areMoviesAvailable(int flightTime, int[] mLength) {

        HashMap<Integer, Integer> movieMap = new HashMap();

        for(int movie: mLength){
           movieMap.put(movie, (flightTime - movie));
        }

        Collection<Integer> c = movieMap.values();
        Iterator<Integer> iter = c.iterator();

        while (iter.hasNext()){
            int value = iter.next();
            if(movieMap.containsKey(value)) return true;
        }
        return false;
    }
    //alternate implementation
    public static boolean canTwoMoviesFillFlight(int[] movieLengths, int flightLength) {

        // movie lengths we've seen so far
        Set<Integer> movieLengthsSeen = new HashSet<>();

        for (int firstMovieLength : movieLengths) {

            int matchingSecondMovieLength = flightLength - firstMovieLength;
            if (movieLengthsSeen.contains(matchingSecondMovieLength)) {
                return true;
            }

            movieLengthsSeen.add(firstMovieLength);
        }

        // we never found a match, so return false
        return false;
    }
}
