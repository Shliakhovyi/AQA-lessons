package collectionsHT;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Task4 {
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //Ваш код
        Map<String, Cat> catMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            String name = "Cat" + i;
            catMap.put(name, new Cat(name));
        }
        return catMap;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        return new HashSet<Cat>(map.values());
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat c : set) {
            System.out.println(c);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }
}
