package timetable;

public class Driver {
    public static final int POPULATION_SIZE = 9;
    public static final double MUTATION_RATE = 0.1;
    public static final double CROSSOVER_RATE = 0.9;
    public static final int TOURNAMENT_SELECTION_SIZE = 3;
    public static final int NUMBER_OF_ELITE_SCHEDULES = 1;
    private Data data;
    public static void main(String[] args) {
        Driver driver = new Driver();
        driver.data = new Data();
        driver.printAvailableData();
    }

    private void printAvailableData() {
        System.out.println("Available Departments ==>");
        data.getDepts().forEach(x -> System.out.println("Name: " + x.getName() + ", Courses: " + x.getCourses()));

        System.out.println("\nAvailable Courses ==>");
        data.getCourses().forEach(x -> System.out.println("Course Number: " + x.getNumber() + ", Name: " + x.getName() + ", Max. NO. of Students: " + x.getMaxNumberOfStudents() + ", Instructor(s): " + x.getInstructors()));

        System.out.println("\nAvailable Venues: ==>");
        data.getVenues().forEach(x -> System.out.println("Venue NUmber: " + x.getNumber() + ", Max Sitting Capacity: " + x.getSeatingCapacity()));

        System.out.println("\nAvailable Instructors ==>");
        data.getInstructors().forEach(x -> System.out.println("Id: " + x.getId() + ", Name: " + x.getName()));

        System.out.println("\nAvailable Meeting Times ==>");
        data.getMeetingTimes().forEach(x -> System.out.println("Id: " + x.getId() + ", Meeting Time: " + x.getTime()));

        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------");

    }
}
