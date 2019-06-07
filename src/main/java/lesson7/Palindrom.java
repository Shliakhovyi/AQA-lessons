package lesson7;

import java.util.Scanner;

public class Palindrom {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Введите фразу палиндром");
        String fraze = reader.nextLine();
        String fraze2 = fraze.replace(" ", "");

        String[] stringToArray = fraze2.split("");

        char temp;
        for (int i = 0; i < stringToArray.length; i++) {


        }

    }

}
