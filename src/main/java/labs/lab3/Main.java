package labs.lab3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // test
//        List<Cinema> cinemas = new ArrayList<>();
//        Cinema cinema1 = new Cinema("cinema1");
//        Cinema cinema2 = new Cinema("cinema2");
//        cinema1.addHall(1, 5, 5);
//        cinema1.addHall(2, 10, 10);
//        cinema2.addHall(1, 10, 10);
//        cinema2.addHall(5, 10, 10);
//        cinema1.createSession(1, "Bobi", "2023-10-23T15:04:23", 120);
//        cinema1.createSession(1, "Boba", "2023-10-23T17:04:23", 120);
//        cinemas.add(cinema1);
//        cinemas.add(cinema2);
//        UI ui = new UI(cinemas);
//        ui.start();

        List<Cinema> cinemas = new ArrayList<>();

        Cinema cinemaA = new Cinema("cinemaA");
        Cinema cinemaB = new Cinema("cinemaB");
        cinemas.add(cinemaA);
        cinemas.add(cinemaB);

        cinemaA.addHall(1, 15, 15);
        cinemaA.addHall(2, 10, 10);
        cinemaB.addHall(1, 10, 10);
        cinemaB.addHall(2, 10, 10);

        cinemaA.createSession(1, "Avatar", "2023-10-15T12:10:00", "2023-10-15T13:10:00");
        cinemaA.createSession(1, "Star Wars", "2023-10-15T19:01:00", "2023-10-15T21:30:00");

        cinemaB.createSession(1, "Matrix 4", "2023-10-15T15:00:00", "2023-10-15T16:10:00");
        cinemaB.createSession(1, "The Dune", "2023-10-15T18:30:00", "2023-10-15T19:10:00");

        cinemaB.createSession(2, "James Bond", "2023-10-16T14:30:00", "2023-10-15T12:10:00");
        cinemaB.createSession(2, "Cruella", "2023-10-16T17:30:00", "2023-10-15T18:10:00");

        UI ui = new UI(cinemas);
        ui.start();

    }
}
