package labs;

import labs.lab1.Lab1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
        int n = sc.nextInt();
        System.out.println(Lab1.getCollatzSteps(n));
         */

        /*
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        System.out.println(Lab1.calculateAlternatingSignSum(numbers));
         */

        /*
        System.out.println(Lab1.findTreasure(sc));
         */

        /*
        int[] result = Lab1.findMaxHeight();
        System.out.println(result[0] + " " + result[1]);
         */

        int n = sc.nextInt();
        System.out.println(Lab1.isDoubleEven(n));
    }
}
