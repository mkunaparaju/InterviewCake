package main.Arrays_Strings;

import main.PrintingHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeMeetingTimes {
    PrintingHelper printingHelper = new PrintingHelper();

    public static void main(String[] args) {
        // setup Done here
        Meeting[] meetings = {new Meeting(0, 1), new Meeting(3, 5), new Meeting(4, 8), new Meeting(10, 12), new Meeting(9, 10)};
        //Meeting [] meetings = {new Meeting(1, 2), new Meeting(2, 3)};
        //  Meeting [] meetings = {new Meeting(1, 5), new Meeting(2, 3)};
        //Meeting[] meetings = {new Meeting(1, 10), new Meeting(2, 6), new Meeting(3, 5), new Meeting(7, 9)};
        MergeMeetingTimes merge = new MergeMeetingTimes();

        PrintingHelper printingHelper = new PrintingHelper();
        // printingHelper.printArray(merge.mergeMeetings(meetings));
        ArrayList<Meeting> listOfMeetings = new ArrayList(Arrays.asList(meetings));
        printingHelper.printList(merge.mergeSorted(listOfMeetings));
        //merge.mergeMeetings(meetings);
    }

    List<Meeting> mergeSorted(ArrayList<Meeting> meetings) {
        ArrayList<Meeting> sorted = new ArrayList<Meeting>(meetings);
        Collections.sort(sorted);
        int i = 1;
        while (i < sorted.size()) {
            Meeting prev = sorted.get(i - 1);
            Meeting present = sorted.get(i);

            if (prev.getEndTime() >= present.getStartTime()) {
                prev.setEndTime((prev.getEndTime() > present.getEndTime()) ? prev.getEndTime() : present.getEndTime());
                sorted.remove(present);
                continue;
            }
            i++;
        }
        return sorted;
    }

    Meeting[] mergeMeetings(Meeting[] meetings) {

        int lowestMeetingStartTime = getLowMeet(meetings);
        int highestMeetingEndTime = getHighMeet(meetings);
        //size double that of diff as 30 min intervals
        int sizeOfTimesArray = (highestMeetingEndTime - lowestMeetingStartTime);

        // System.out.println(lowestMeetingStartTime + " " + highestMeetingEndTime + " " + sizeOfTimesArray);
        int[] times = new int[sizeOfTimesArray + 1];
        Meeting[] mergedMeetings = new Meeting[meetings.length];

        for (Meeting m : meetings) {
            int meetStart = m.getStartTime() - lowestMeetingStartTime;
            int meetEnd = m.getEndTime() - lowestMeetingStartTime;
            //System.out.println(meetStart + " " + meetEnd);
            for (int i = meetStart; i < meetEnd; i++) {
                times[i]++;
            }
        }
        printingHelper.printArray(times);
        int count = 0, start = 0, end = 0;

        while (end < times.length) {
            if (times[end] == 0) {
                System.out.println("start " + start + " end " + end + " count " + count);
                if (start == end) {
                    start = end + 1;
                    end++;
                    continue;
                }
                Meeting newMerged = new Meeting(start + lowestMeetingStartTime, end + lowestMeetingStartTime);
                mergedMeetings[count] = newMerged;
                System.out.println(mergedMeetings[count]);
                count++;
                start = end + 1;
            }
            end++;
            System.out.println(end);
        }
        return mergedMeetings;
    }

    int getLowMeet(Meeting[] meetings) {
        int low = Integer.MAX_VALUE;
        for (Meeting m : meetings) {
            if (m.getStartTime() < low) low = m.getStartTime();
        }
        return low;
    }

    //assumption is meeting time cannot be lower than 0
    int getHighMeet(Meeting[] meetings) {
        int high = 0;
        for (Meeting m : meetings) {
            if (m.getEndTime() > high) high = m.getEndTime();
        }
        return high;
    }
}

class Meeting implements Comparable<Meeting> {

    private int startTime;
    private int endTime;

    public Meeting(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }


    @Override
    public String toString() {
        return "Meeting{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    @Override
    public int compareTo(Meeting o) {
        return this.getStartTime() - o.getStartTime();
    }
}
