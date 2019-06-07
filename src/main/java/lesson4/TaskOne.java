package lesson4;

import java.util.Scanner;

public class TaskOne {

    public static void main(String[] args) {

        //TASK 1
        //Read 4 integers
        Scanner reader = new Scanner(System.in);
        System.out.println("Please, enter 4 integers");
        int a = reader.nextInt();
        int b = reader.nextInt();
        int c = reader.nextInt();
        int d = reader.nextInt();
        //Min integer:
        System.out.print("Min integer: ");
        if (a < b && a < c && a < d) {
            System.out.println(a);
        } else if (b < a && b < c && b < d) {
            System.out.println(b);
        } else if (c < a && c < b && c < d) {
            System.out.println(c);
        } else {
            System.out.println(d);
        }


        //TASK 2
        //Count of Max integers:
        int max = Math.max(Math.max(a, b), Math.max(c, d));

        int countMax = 0;
        int[] countNumbers = {a, b, c, d};
        for (int temp : countNumbers) {
            if (temp == max) {
                countMax++;
            }
        }
        System.out.println("\nCount of max numbers: " + countMax);


        //TASK 3
        //Min and Max integer
        System.out.println("\nPlease, enter one more integer: ");
        int e = reader.nextInt();

        int minFive = Math.min(Math.min(Math.min(a, b), Math.min(c, d)), e);
        System.out.println("Min integer from five numbers: " + minFive);

        int maxFive = Math.max(Math.max(Math.max(a, b), Math.max(c, d)), e);
        System.out.println("Max integer from five numbers: " + maxFive);


        //TASK 4
        String nameOne = "Slava";
        String nameTwo = "Slava";

        if (nameOne.equals(nameTwo)) {
            System.out.println("\nThey have same names!");
        } else {
            System.out.println("Thay have different names.");
        }


        //TASK 5
        System.out.println("\nPlease, enter number from [1 to 4]");
        int num = reader.nextInt();

        switch (num) {

            case 1:
                System.out.println("Winter");
                break;

            case 2:
                System.out.println("Spring");
                break;

            case 3:
                System.out.println("Summer");
                break;

            case 4:
                System.out.println("October");
                break;

            default:
                System.out.println("Number from [1 to 4]!");
        }
    }
}
