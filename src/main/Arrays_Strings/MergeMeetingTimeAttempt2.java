package main.Arrays_Strings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MergeMeetingTimeAttempt2 {

    public static void main(String[] args) {
        List<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting(0,1));
        meetings.add(new Meeting(3,5));
        meetings.add(new Meeting(4,8));
        meetings.add(new Meeting(9,10));
        meetings.add(new Meeting(10,12));

        List<Meeting> mergedMeetings = mergeMeeting(meetings);

        for (Meeting m: mergedMeetings ) {
            System.out.println(m.getStartTime() +  " " + m.getEndTime());
        }
    }

    private static List<Meeting> mergeMeeting(List<Meeting> meetings) {
        Collections.sort(meetings);

        for(int i = 0; i < meetings.size() - 1; i++){
//            System.out.println(meetings.get(i).getStartTime() + " " + meetings.get(i+1).getEndTime());
            if(meetings.get(i).getEndTime() >= meetings.get(i+1).getStartTime()) {
//                System.out.println(meetings.get(i).getStartTime() + " " + meetings.get(i+1).getEndTime());
                Meeting merged = new Meeting(meetings.get(i).getStartTime(), meetings.get(i+1).getEndTime());

               //removing twice as when we remove once, the next one slides into this position (pos i).
                meetings.remove(i);;
                meetings.remove(i);;
                meetings.add(i, merged);
            }
        }
        return meetings;
    }
}

