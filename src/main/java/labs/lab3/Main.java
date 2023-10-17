package labs.lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import static labs.lab3.Cinema.findNearestMovie;

public class Main {
    public static void main(String[] args) {
        List<Cinema> cinemas = new ArrayList<>();
        Cinema cinema1 = new Cinema("cinema1");
        Cinema cinema2 = new Cinema("cinema2");
        cinema1.addHall(1, 5, 5);
        cinema1.addHall(2, 10, 10);
        cinema2.addHall(1, 10, 10);
        cinema2.addHall(5, 10, 10);
        cinema1.createSession(1, "Bebra", "2023-10-23T15:04:23", 120);
        cinema1.createSession(1, "Bebraa", "2023-10-23T17:04:23", 120);
        cinemas.add(cinema1);
        cinemas.add(cinema2);
        UI ui = new UI(cinemas);
        ui.start();

    }
}
