package lesson2;

import java.util.Scanner;

public class MathThree {
    public static void main(String[] args) {

        //Enter and save decimal number
        Scanner read = new Scanner(System.in);
        System.out.println("Enter your decimal number: ");
        double decimal = read.nextDouble();

        //Round and output integer
        int roundInteger = (int) Math.round(decimal);
        System.out.println(roundInteger);

    }
}

