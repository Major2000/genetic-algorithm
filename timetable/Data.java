package timetable;
import java.util.ArrayList;
import java.util.Arrays;

import timetable.GeneticAlgorithm.Course;
import timetable.GeneticAlgorithm.Department;
import timetable.GeneticAlgorithm.Instructor;
import timetable.GeneticAlgorithm.MeetingTime;
import timetable.GeneticAlgorithm.Venue;

public class Data {
    private ArrayList<Venue> venues;
    private ArrayList<Instructor> instructors;
    private ArrayList<Course> courses;
    private ArrayList<Department> depts;
    private ArrayList<MeetingTime> meetingTimes;
    private int numberOfClasses = 0;

    public Data() { initialize(); }

    private Data initialize() {
        Venue venue1 = new Venue("LUHANGA", 100);
        Venue venue2 = new Venue("B106", 80);
        Venue venue3 = new Venue("B305", 70);
        Venue venue4 = new Venue("D28", 90);

        MeetingTime meetingTime1 = new MeetingTime("MT1", "OHP 09:00 - 10:00");
        MeetingTime meetingTime2 = new MeetingTime("MT2", "OHP 10:00 - 11:00");
        MeetingTime meetingTime3 = new MeetingTime("MT3", "THP 09:00 - 11:00");
        MeetingTime meetingTime4 = new MeetingTime("MT4", "THP 11:00 - 13:00");
  

        venues = new ArrayList<Venue>(Arrays.asList(venue1, venue2, venue3, venue4));
        return this; 
    }

    public ArrayList<Venue> getVenues() { return venues; }
    public ArrayList<Instructor> getInstructors() { return instructors; }
    public ArrayList<Course> getCourses() { return courses; }
    public ArrayList<Department> getDepts() { return depts; }
    public ArrayList<MeetingTime> getMeetingTimes() { return meetingTimes; }
    public int getNumberOfClasses() { return this.numberOfClasses; }
}
