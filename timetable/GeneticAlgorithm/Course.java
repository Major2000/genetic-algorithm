package timetable.GeneticAlgorithm;

public class Course {
    private String number = null;
    private String name = null;
    private int maxNumberOfStudents;
    private Instructor[] instructors;

    public Course(String number, String name, Instructor[] instructors, int maxNumberOfStudents) {
        this.number = number;
        this.name = name;
        this.instructors = instructors;
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public String getNumber() { return number; }
    public String getName() { return name; }
    public Instructor[] getInstructors() { return instructors; }
    public int getmaxNumberOfStudents() { return maxNumberOfStudents; }
    public String toString() { return name; }
}
