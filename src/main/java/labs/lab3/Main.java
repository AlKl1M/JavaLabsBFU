package labs.lab3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Cinema> cinemas = new ArrayList<>();
        UI ui = new UI(cinemas);
        ui.start();
    }
}
