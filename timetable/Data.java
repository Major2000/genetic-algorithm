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

        //Venues
        Venue venue1 = new Venue("LUHANGA", 100);
        Venue venue2 = new Venue("B106", 80);
        Venue venue3 = new Venue("B305", 70);
        Venue venue4 = new Venue("D28", 90);
        venues = new ArrayList<Venue>(Arrays.asList(venue1, venue2, venue3, venue4));

        //Meeting Times
        MeetingTime meetingTime1 = new MeetingTime("MT1", "OHP 09:00 - 10:00");
        MeetingTime meetingTime2 = new MeetingTime("MT2", "OHP 10:00 - 11:00");
        MeetingTime meetingTime3 = new MeetingTime("MT3", "THP 09:00 - 11:00");
        MeetingTime meetingTime4 = new MeetingTime("MT4", "THP 11:00 - 13:00");
        meetingTimes = new ArrayList<MeetingTime>(Arrays.asList(meetingTime1, meetingTime2, meetingTime3, meetingTime4));

        //Instructors
        Instructor instructor1 = new Instructor("I1", "Dr. Andongyse");
        Instructor instructor2 = new Instructor("I2", "Mr. John Web");
        Instructor instructor3 = new Instructor("I3", "Ms. Suzana Inn");
        Instructor instructor4 = new Instructor("I4", "Prof. Inuza Kinn");
        instructors = new ArrayList<Instructor>(Arrays.asList(instructor1, instructor2, instructor3, instructor4));

        //Courses
        Course course1 = new Course("C1", "MT 261", new ArrayList<Instructor>(Arrays.asList(instructor1, instructor2)), 100);
        Course course2 = new Course("C2", "ES 211", new ArrayList<Instructor>(Arrays.asList(instructor4)), 40);
        Course course3 = new Course("C3", "EE 256", new ArrayList<Instructor>(Arrays.asList(instructor1, instructor2)), 50);
        Course course4 = new Course("C4", "ES 212", new ArrayList<Instructor>(Arrays.asList(instructor3)), 80);
        Course course5 = new Course("C5", "ES 213", new ArrayList<Instructor>(Arrays.asList(instructor2, instructor3)), 26);
        Course course6 = new Course("C6", "IS 243", new ArrayList<Instructor>(Arrays.asList(instructor2)), 52);
        Course course7 = new Course("C7", "CS 236", new ArrayList<Instructor>(Arrays.asList(instructor1, instructor4)), 37);
        courses = new ArrayList<Course>(Arrays.asList(course1, course2, course3, course4, course5, course6, course7));

        //Departments
        Department dept1 = new Department("MATHEMATICS", new ArrayList<Course>(Arrays.asList(course1, course3)));
        Department dept2 = new Department("COMPUTER SCIENCE", new ArrayList<Course>(Arrays.asList(course7)));
        Department dept3 = new Department("ETE", new ArrayList<Course>(Arrays.asList(course2, course4, course5, course6)));
        depts = new ArrayList<Department>(Arrays.asList(dept1, dept2, dept3));
        depts.forEach(x -> numberOfClasses += x.getCourses().size());

        return this; 
    }

    public ArrayList<Venue> getVenues() { return venues; }
    public ArrayList<Instructor> getInstructors() { return instructors; }
    public ArrayList<Course> getCourses() { return courses; }
    public ArrayList<Department> getDepts() { return depts; }
    public ArrayList<MeetingTime> getMeetingTimes() { return meetingTimes; }
    public int getNumberOfClasses() { return this.numberOfClasses; }
}
