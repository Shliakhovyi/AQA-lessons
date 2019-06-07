package lesson2;

import java.util.Scanner;

public class MathTwo {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        System.out.println("Enter your integer number: ");

        int sum = 0;
        for (int temp = read.nextInt(); temp > 0; temp /= 10) {
            sum += (temp % 10);
        }
        System.out.println(sum);

    }
}