package collectionsHT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();

        //заполните список строками при помощи reader.readLine();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        sort(list); //метод для сортировки списка

        //вывести список в отсортированном порядке
        for (String alist : list) {
            System.out.println(alist);
        }
    }

    public static void sort(List<String> list) {
        //реализуйте свой алгоритм сортировки списка при помощи  метода isGreaterThan(String a, String b)
        for (int k = 0; k < list.size(); k++) {
            for (int i = 0; i < list.size()-1; i++) {
                if (isGreaterThan(list.get(i), list.get(i+1))) {
                    String temp = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1, temp);
                }
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }
}
