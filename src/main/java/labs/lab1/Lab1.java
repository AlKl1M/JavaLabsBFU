package labs.lab1;

public class Lab1 {
    public static int getCollatzSteps(int n) {
        int steps = 0;
        if (n == 1) {
            n = 3 * n + 1;
            steps++;
        }
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            steps++;
        }
        return steps;
    }
}
