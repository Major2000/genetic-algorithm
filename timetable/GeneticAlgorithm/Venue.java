package timetable.GeneticAlgorithm;

public class Venue {
    private String number;
    private int seatingCapacity;

    public Venue(String number, int seatingCapacity) {
        this.number = number;
        this.seatingCapacity = seatingCapacity;
    }

    public String getNumber() { return number; }
    public int getSeatingCapacity() { return seatingCapacity; }
}
