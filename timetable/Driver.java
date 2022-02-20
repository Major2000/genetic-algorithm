package timetable;
import timetable.GeneticAlgorithm.Class;
import java.util.ArrayList;

public class Driver {
    public static final int POPULATION_SIZE = 9;
    public static final double MUTATION_RATE = 0.1;
    public static final double CROSSOVER_RATE = 0.9;
    public static final int TOURNAMENT_SELECTION_SIZE = 3;
    public static final int NUMBER_OF_ELITE_SCHEDULES = 1;
    private int scheduleNumber = 0;
    private int classNumber = 1;
    private Data data;


    public static void main(String[] args) {
        Driver driver = new Driver();
        int generationNumber = 0;
        driver.data = new Data();
        driver.printAvailableData();

        System.out.println ("> Generation Number: " + generationNumber);
        System.out.print("  Schedule NUmber |                                                                    ");
        System.out.print("Classes [Dept,Class,Venue,Instructor,Meeting-Time]                                     ");
        System.out.println("                                                                | Fitness | Conflicts");
        System.out.println("-------------------------------------------------------------------------------------------"+
                           "-----------------");
        System.out.println("-------------------------------------------------------------------------------------------"+
                           "-------------------");

        GeneticAlg geneticAlgorithm = new GeneticAlg(driver.data);
        Population population = new Population(Driver.POPULATION_SIZE, driver.data).sortByFitness();
        population.getSchedules().forEach(schedule -> System.out.println("     " + driver.scheduleNumber++ + "     | " + schedule + " | " + String.format(".5%f", schedule.getFitness()) + " | " + schedule.getNumberOfConflicts()));

        driver.printScheduleAsTable(population.getSchedules().get(0), generationNumber);

        driver.classNumber = 1;

        while (population.getSchedules().get(0).getFitness() != 1.0) {
            System.out.println("> Generation Number: " + ++generationNumber);
            System.out.print("  Schedule NUmber |                                                                    ");
            System.out.print("Classes [Dept,Class,Venue,Instructor,Meeting-Time]                                     ");
            System.out.println("                                                                | Fitness | Conflicts");
            System.out.println("-------------------------------------------------------------------------------------------"+
                               "-----------------");
            System.out.println("-------------------------------------------------------------------------------------------"+
                               "-------------------");
            
            population = geneticAlgorithm.evolve(population).sortByFitness();
            driver.scheduleNumber = 0;
            population.getSchedules().forEach(schedule -> System.out.println("     " + driver.scheduleNumber++ + "     | " + schedule + " | " + String.format(".5%f", schedule.getFitness()) + " | " + schedule.getNumberOfConflicts()));

            driver.printScheduleAsTable(population.getSchedules().get(0), generationNumber);

            driver.classNumber = 1;    
        }
    }

    private void printScheduleAsTable(Schedule schedule, int generation) {
        ArrayList<Class> classes = schedule.getClasses();
        System.out.print("\n                         ");
        System.out.println("Class Number | Dept | Course (Number, Max No.of Students | Room (Capacity) | Instructor (Id) | Meeting Time (Id)");
        System.out.print("                            ");
        System.out.print("---------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------");

        classes.forEach(x -> {
            int majorIndex = data.getDepts().indexOf(x.getDept());
            int courseIndex = data.getCourses().indexOf(x.getCourse());
            int venuesIndex = data.getVenues().indexOf(x.getVenue());
            int instructorIndex = data.getInstructors().indexOf(x.getInstructor());
            int meetingIndex = data.getMeetingTimes().indexOf(x.getMeetingTime());
            System.out.print("                     ");
            System.out.print(String.format(" %1$02d ", classNumber) + " | ");
            System.out.print(String.format("%1$4s", data.getDepts().get(majorIndex).getName()) + " | ");
            System.out.print(String.format("%1$21s", data.getCourses().get(courseIndex).getName() + " (" + data.getCourses().get(courseIndex).getNumber() + ", " + x.getCourse().getMaxNumberOfStudents()) + ")     | ");
            System.out.print(String.format("%1$10s", data.getVenues().get(venuesIndex).getNumber() + " (" + x.getVenue().getSeatingCapacity()) + ")     | ");
            System.out.print(String.format("%1$15s", data.getInstructors().get(instructorIndex).getName() + " (" + data.getInstructors().get(instructorIndex).getId() + ")") + "  | ");
            System.out.println(data.getMeetingTimes().get(meetingIndex).getTime() + " (" + data.getMeetingTimes().get(meetingIndex).getId() + ")");

            classNumber++;
        });

        if (schedule.getFitness() == 1) System.out.println("> Solution Found in " + (generation + 1) + "generations");
        System.out.print("-----------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------------");
                
    }

    private void printAvailableData() {
        System.out.println("Available Departments ==>");
        data.getDepts().forEach(x -> System.out.println("Name: " + x.getName() + ", Courses: " + x.getCourses()));

        System.out.println("\nAvailable Courses ==>");
        data.getCourses().forEach(x -> System.out.println("Course Number: " + x.getNumber() + ", Name: " + x.getName() + ", Max. NO. of Students: " + x.getMaxNumberOfStudents() + ", Instructor(s): " + x.getInstructors()));

        System.out.println("\nAvailable Venues: ==>");
        data.getVenues().forEach(x -> System.out.println("Venue Number: " + x.getNumber() + ", Max Sitting Capacity: " + x.getSeatingCapacity()));

        System.out.println("\nAvailable Instructors ==>");
        data.getInstructors().forEach(x -> System.out.println("Id: " + x.getId() + ", Name: " + x.getName()));

        System.out.println("\nAvailable Meeting Times ==>");
        data.getMeetingTimes().forEach(x -> System.out.println("Id: " + x.getId() + ", Meeting Time: " + x.getTime()));

        System.out.println("-------------------------------------------------------------------------------------------"+
                           "-----------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------"+
                           "-----------------------------------");

    }
}
