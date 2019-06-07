package lesson2;

import java.util.Scanner;

public class ConsoleDataType {
    public static void main(String[] args) {
        //Enter and save char from console
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter some char: ");
        char c = reader.next().trim().charAt(0);
        //Output int from char
        int i = (int) c;
        System.out.println(i);

        //Enter and save int from console
        System.out.println("\nEnter some integer: ");
        int intFromConsole = reader.nextInt();
        //Output char from int
        char character = (char) intFromConsole;
        System.out.println(character);

    }
}
