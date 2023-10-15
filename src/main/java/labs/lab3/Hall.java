package labs.lab3;

import java.util.HashMap;
import java.util.Map;

public class Hall {
    private int rows;
    private int seatsPerRow;
    private Map<String, MovieSession> sessions;

    public Hall(int rows, int seatsPerRow) {
        this.rows = rows;
        this.seatsPerRow = seatsPerRow;
        this.sessions = new HashMap<>();
    }

    public void configureSeats(int[][] seats) {
        if (seats.length != rows || seats[0].length != seatsPerRow) {
            System.out.println("Invalid seats config");
            return;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsPerRow; j++) {
                if (seats[i][j] == 0) {
                    System.out.println("Seat at row " + (i + 1) + ", seat " + (j + 1) + " is now available.");
                }
            }
        }
    }

    public void createSession(String movieTitle, String startTime) {
        if (sessions.containsKey(startTime)) {
            System.out.println("Session at " + startTime + " already exists");
            return;
        }
        MovieSession session = new MovieSession(movieTitle, startTime, rows, seatsPerRow);
        sessions.put(startTime, session);
    }


    public void buyTicket(String movieTitle, String startTime, int row, int seat) {
        if (sessions.containsKey(startTime)) {
            MovieSession session = sessions.get(startTime);
            session.buyTicket(movieTitle, row, seat);
        } else {
            System.out.println("Movie session at " + startTime + " does not exist");
        }
    }
}
