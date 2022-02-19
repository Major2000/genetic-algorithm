package timetable.GeneticAlgorithm;

public class Class {
    private int id;
    private Department dept;
    private Course course;
    private Instructor instructor;
    private MeetingTime meetingTime;
    private Venue venue;

    public Class(int id, Department dept, Course course) {
        this.id = id;
        this.course = course;
        this.dept = dept;
    }

    public void setInstructor(Instructor instructor) { this.instructor = instructor; }
    public void setMeetingTime(MeetingTime meetingTime) { this.meetingTime = meetingTime; }
    public void setVenue(Venue venue) { this.venue = venue; }

    public int getId() { return id; }
    public Department getDept() { return dept; }
    public Course getCourse() { return course; }
    public Instructor getInstructor() { return instructor; }
    public MeetingTime getMeetingTime() { return meetingTime; }
    public Venue getVenue() { return venue; }

    public String toString() {
        return "[" + dept.getName() + ", " + course.getNumber() + ", " + venue.getNumber() + ", " + instructor.getId() + ", " + meetingTime.getId() + "]";
    }
}
