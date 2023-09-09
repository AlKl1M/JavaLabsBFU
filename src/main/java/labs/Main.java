package labs;

import labs.lab1.Lab1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(Lab1.getCollatzSteps(sc.nextInt()));
    }
}
