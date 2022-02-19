package timetable.GeneticAlgorithm;

public class Department {
    private String name;
    private Course[] courses;
    
    public Department(String name, Course[] courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() { return name; }
    public Course[] getCourses() { return courses; }
}
