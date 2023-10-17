package labs.lab3;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static labs.lab3.Cinema.findNearestMovie;

public class UI {
    private Scanner scanner;
    private List<Cinema> cinemas;
    public UI(List<Cinema> cinemas) {
        scanner = new Scanner(System.in);
        this.cinemas = cinemas;
    }
    public void start() {
        boolean running = true;
        boolean adminFlag = isAdmin();
        while (running) {
            if (adminFlag) {
                printAdminMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> createCinema();
                    case 2 -> createHall();
                    case 4 -> createMovieSession();
                    case 5 -> showCinemas();
                    case 6 -> showCinemaInfo();
                    case 7 -> {
                        break;
                    }
                    case 8 -> running = false;
                }
            } else {
                printUserMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> buyTicket();
                    case 2 -> findNearestMovieSession();
                    case 3 -> {
                        break;
                    }
                    case 4 -> running = false;
                }
            }
        }

    }

    private void printAdminMenu() {
        System.out.println("\n-- Admin Operations --");
        System.out.println("1. Create cinema");
        System.out.println("2. Create hall");
        System.out.println("3. Configure seats");
        System.out.println("4. Create movie session");
        System.out.println("5. Show cinemas");
        System.out.println("6. Show cinema info");
        System.out.println("7. Logout");
        System.out.println("8. Exit");
        System.out.println("Enter your choice: ");
    }

    private void printUserMenu() {
        System.out.println("\n-- User Operations --");
        System.out.println("1. Buy ticket");
        System.out.println("2. Find nearest movie session");
        System.out.println("3. Logout");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
    }

    public boolean isAdmin () {
        System.out.println("Hello, enter your login and password");
        String login = scanner.nextLine();
        String password = scanner.nextLine();
        if (login.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
            return true;
        } else {
            return false;
        }
    }

    public void createCinema() {
        System.out.println("Enter name of the cinema");
        String name = scanner.nextLine();
        Cinema cinema = new Cinema(name);
        cinemas.add(cinema);
        System.out.println("Cinema was created: ");
    }

    public void createHall() {
        System.out.println("Enter id of the hall");
        int id = scanner.nextInt();
        System.out.println("Enter number of rows");
        int rows = scanner.nextInt();
        System.out.println("Enter number of seats per row");
        int seatsPerRow = scanner.nextInt();
        System.out.println("Finally, enter name of the cinema where u want to create hall");
        String cinemaName = scanner.nextLine();
        scanner.nextLine();
        for (Cinema cinema : cinemas) {
            if (cinema.getName().equals(cinemaName)) {
                cinema.addHall(id, rows, seatsPerRow);
            }
        }
    }

    public void createMovieSession() {
        System.out.println("Enter number of hall, where u want to create movie session");
        int id = scanner.nextInt();
        System.out.println("Enter movie title");
        String title = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter time where movie starts (pattern - <yyyy-mm-ddThh:mm:ss>)");
        String date = scanner.nextLine();
        System.out.println("Enter duration of this movie (in minutes)");
        int duration = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Finally, enter name of the cinema, where u want to create this movie session");
        String cinemaName = scanner.nextLine();
        for (Cinema cinema : cinemas) {
            if (cinema.getName().equals(cinemaName)) {
                cinema.createSession(id, title, date, duration);
            }
        }
    }

    public void showCinemas() {
        System.out.println("Here list of cinemas: ");
        for (Cinema cinema : cinemas) {
            System.out.println(cinema.toString());
        }
    }

    public void showCinemaInfo() {
        System.out.println("Enter name of cinema that u want to see: ");
        String cinemaName = scanner.nextLine();
        for (Cinema cinema : cinemas) {
            if (cinema.getName().equals(cinemaName)) {
                System.out.println("Here list of movie sessions ");
                for (Map.Entry<Integer, Hall> entry: cinema.getHalls().entrySet()) {
                    for (MovieSession movieSession : entry.getValue().getSessions().values()) {
                        System.out.println("---------------------------");
                        System.out.println(movieSession.toString());
                        movieSession.displaySeats();
                    }
                }
            }
        }
    }

    public void buyTicket() {
        System.out.println("Here list of cinemas, where u can buy a ticket");
        for (Cinema cinema : cinemas) {
            System.out.println(cinema.toString());
        }
        System.out.println("Enter name of cinema where u want to buy a ticket");
        String cinemaName = scanner.nextLine();
        for (Cinema cinema : cinemas) {
            if (cinema.getName().equals(cinemaName)) {
                System.out.println("Here list of movie sessions today: ");
                for (Map.Entry<Integer, Hall> entry: cinema.getHalls().entrySet()) {
                    for (MovieSession movieSession : entry.getValue().getSessions().values()) {

                        System.out.println("---------------------------");
                        System.out.println(movieSession.toString());
                        movieSession.displaySeats();
                    }
                }

                System.out.println("Enter hall number, where u want to buy a ticket");
                int hallNumber = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter movie title");
                String title = scanner.nextLine();
                System.out.println("Enter date (pattern - <yy-mm-ddThh:mm:ss>)");
                String date = scanner.nextLine();
                System.out.println("Enter row");
                int row = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter seat");
                int seat = scanner.nextInt();
                scanner.nextLine();
                cinema.buyTicket(hallNumber, title, date, row, seat);
            }
        }
    }

    public void findNearestMovieSession() {
        System.out.println("Enter title of movie: ");
        String title = scanner.nextLine();
        try {
            List<String> result = findNearestMovie(cinemas, title);
            System.out.println("Clothest cinema where u can watch " + title + " is " + result.get(1) + ". Start time: " + result.get(0));
        } catch (NullPointerException e) {
            System.out.println("Where are no nearest movie");
        }
    }
}
