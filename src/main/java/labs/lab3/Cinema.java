package labs.lab3;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
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
    public void createSession(int hallNumber, String movieTitle, String startTime, int duration) {
        if (halls.containsKey(hallNumber)) {
            Hall hall = halls.get(hallNumber);
            hall.createSession(movieTitle, startTime, duration);
        } else {
            System.out.println("Hall with number " + hallNumber + " does not exist");
        }
    }

    public void printPlan(int hallNumber, String movieTitle, String startTime) {
        if (halls.containsKey(hallNumber)) {
            Hall hall = halls.get(hallNumber);
            Map<String, MovieSession> sessions = hall.getSessions();
            for (Map.Entry<String, MovieSession> entry : sessions.entrySet()) {
                if (entry.getValue().getMovieTitle().equals(movieTitle) &&
                entry.getValue().getStartTime().equals(startTime)) {
                    int[][] seats = entry.getValue().getSeats();
                    System.out.println("Seats in the hall:");
                    for (int i = 0; i < seats.length; i++) {
                        for (int j = 0; j < seats[i].length; j++) {
                            if (seats[i][j] == 0) {
                                System.out.print("X ");
                            } else {
                                System.out.print("O ");
                            }
                        }
                        System.out.println();
                    }
                }
            }
        }
    }

    public List<String> findNearestMovie(List<Cinema> cinemas, String movieTitle) {
        List<String> result = new ArrayList<>();
        MovieSession nearestMovie = null;
        String nearestCinema = "";
        LocalDateTime currentTime = LocalDateTime.now();
        Duration shortestDuration = null;
        for (Cinema cinema: cinemas) {
            for (Hall hall : cinema.getHalls().values()) {
                for (MovieSession session : hall.getSessions().values()) {
                    if (!session.getMovieTitle().equals(movieTitle)) {
                        continue;
                    }
                    LocalDateTime sessionStartTime = LocalDateTime.parse(session.getStartTime());
                    Duration duration = Duration.between(currentTime, sessionStartTime);
                    if (duration.isNegative()) {
                        continue;
                    }
                    if (shortestDuration == null || duration.compareTo(shortestDuration) < 0) {
                        shortestDuration = duration;
                        nearestMovie = session;
                        nearestCinema = cinema.getName();
                    }
                }
            }
        }
        result.add(nearestMovie.getStartTime());
        result.add(nearestCinema);
        return result;
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
