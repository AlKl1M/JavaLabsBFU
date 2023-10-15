package labs.lab3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema("First");
        cinema.addHall(1, 10, 10);
        int[][] array = new int[10][10];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = 0;
            }
        }
        cinema.configureHallSeats(1, array);
        cinema.createSession(1, "Movie 1", "15:00");
        cinema.createSession(1, "Movie 2", "18:00");
        cinema.createSession(1, "Movie 3", "21:00");
        cinema.buyTicket(1, "Movie 1", "15:00", 5, 5);
    }
}
