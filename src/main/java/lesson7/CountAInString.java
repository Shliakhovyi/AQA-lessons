package lesson7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountAInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        List<Integer> ints = new ArrayList<Integer>();

        for (int i = 0; i < str.length(); i++) {
            if ('a' == str.charAt(i)) {
                ints.add(str.indexOf('a', i));
            }
        }
        System.out.println("Количество а: " + ints.size());
        System.out.println("Индексы" + ints);
    }
}
