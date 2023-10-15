package labs.lab3;

import java.util.HashMap;
import java.util.Map;

public class Cinema {
    private String name;
    private Map<Integer, Hall> halls;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, Hall> getHalls() {
        return halls;
    }

    public void setHalls(Map<Integer, Hall> halls) {
        this.halls = halls;
    }

    public Cinema(String name) {
        this.name = name;
        this.halls = new HashMap<>();
    }
    public void addHall(int hallNumber, int rows, int seatsPerRow) {
        Hall hall = new Hall(rows, seatsPerRow);
        halls.put(hallNumber, hall);
    }

    public void configureHallSeats(int hallNumber, int[][] seats) {
        if (halls.containsKey(hallNumber)) {
            halls.get(hallNumber).configureSeats(seats);
        } else {
            System.out.println("Hall with number " + hallNumber + " does not exist");
        }
    }
    public void createSession(int hallNumber, String movieTitle, String startTime) {
        if (halls.containsKey(hallNumber)) {
            Hall hall = halls.get(hallNumber);
            hall.createSession(movieTitle, startTime);
        } else {
            System.out.println("Hall with number " + hallNumber + " does not exist");
        }
    }

    public void buyTicket(int hallNumber, String movieTitle, String startTime, int row, int seat) {
        if (halls.containsKey(hallNumber)) {
            Hall hall = halls.get(hallNumber);
            hall.buyTicket(movieTitle, startTime, row, seat);
        } else {
            System.out.println("Hall with number " + hallNumber + " does not exist");
        }
    }
}
