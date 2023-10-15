package labs.lab3;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
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

    public MovieSession findNearestMovie() {
        MovieSession nearestMovie = null;
        LocalDateTime currentTime = LocalDateTime.now();
        Duration shortestDuration = null;
        for (Hall hall : halls.values()) {
            for (MovieSession session : hall.getSessions().values()) {
                LocalDateTime sessionStartTime = LocalDateTime.parse(session.getStartTime());
                Duration duration = Duration.between(currentTime, sessionStartTime);
                if (duration.isNegative()) {
                    continue;
                }
                if (shortestDuration == null || duration.compareTo(shortestDuration) < 0) {
                    shortestDuration = duration;
                    nearestMovie = session;
                }
            }
        }
        return nearestMovie;
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
