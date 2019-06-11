package collectionsHT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListTask3 {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> list) {
        int ind = list.indexOf(Collections.min(list));
        return list.get(ind);
    }

    public static List<Integer> getIntegerList() throws IOException {
        //Ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> intList = new ArrayList<>();
        System.out.println("Введите число n (количество чисел в списке)");
        String s = reader.readLine();
        int n = Integer.parseInt(s);
        System.out.println("Введите " + n + " чисел");
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            int j = Integer.parseInt(line);
            intList.add(j);
        }
        return intList;
    }
}
