package lesson2;

import java.util.Scanner;

public class MathOne {
    public static void main(String[] args) {

        //Enter and save numerator and denominator
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter first natural number: ");
        int q = reader.nextInt();
        System.out.println("Enter second natural number: ");
        int w = reader.nextInt();


        //Print result and rest if q > w OR print double result if q < w
        if(q > w) {
            int result = q / w;
            int rest = q % w;
            System.out.println(q + " / " + w + " = " + result + " и " + rest + " в остатке");
        } else {
            double doubleResult = (double) q / w;
            System.out.println(q + " / " + w + " = " + doubleResult);
        }

    }
}
