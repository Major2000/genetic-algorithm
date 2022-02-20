package timetable;
import java.util.ArrayList;
import timetable.GeneticAlgorithm.Class;
import timetable.GeneticAlgorithm.Department;


public class Schedule {
    private ArrayList<Class> classes;
    private int classNumb = 0;
    private boolean isFitnessChanged = true;
    private double fitness = -1;
    private int numberOfConflicts = 0;
    private Data data;

    public Data getData() { return data; }

    public Schedule(Data data) {
        this.data = data;
        classes = new ArrayList<Class>(data.getNumberOfClasses());
    }

    public Schedule initialize() {
        new ArrayList<Department>(data.getDepts()).forEach(dept -> {
            dept.getCourses().forEach(course -> {
                Class newClass = new Class(classNumb++, dept, course);
                newClass.setMeetingTime(data.getMeetingTimes().get((int) (data.getMeetingTimes().size() * Math.random())));
                newClass.setVenue(data.getVenues().get((int) (data.getVenues().size() * Math.random())));
                newClass.setInstructor(course.getInstructors().get((int) (course.getInstructors().size() * Math.random())));
                classes.add(newClass);
            });
        });        
        return this;
    }

    public int getNumberOfConflicts() { return numberOfConflicts; }

    public ArrayList<Class> getClasses() {
        isFitnessChanged = true;
        return classes;
    }

    public double getFitness() {
        if (isFitnessChanged == true) {
            fitness = calculateFitness();
            isFitnessChanged = false;
        }
        return fitness;
    }

    private double calculateFitness() {
       numberOfConflicts = 0;
       classes.forEach(x -> {
           if (x.getVenue().getSeatingCapacity() < x.getCourse().getMaxNumberOfStudents()) numberOfConflicts++;
           classes.stream().filter(y -> classes.indexOf(y) >= classes.indexOf(x)).forEach(y -> {
               if (x.getMeetingTime() == y.getMeetingTime() && x.getId() != y.getId()) {
                   if (x.getVenue() == y.getVenue()) numberOfConflicts++;
                   if (x.getInstructor() == y.getInstructor()) numberOfConflicts++;
               }
           });
       });
       return 1 / (double) (numberOfConflicts + 1);
    }

    public String toString() {
        String returnValue = new String();
        for (int x = 0; x < classes.size() - 1; x++) returnValue += classes.get(x) + ",";
        returnValue += classes.get(classes.size() - 1);
        return returnValue;
    }
}