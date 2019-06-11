package collectionsHT;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats() {
        Set<Cat> cats = new HashSet<>();
        cats.add(new Cat("Cat1"));
        cats.add(new Cat("Cat2"));
        cats.add(new Cat("Cat3"));
        cats.add(new Cat("Cat4"));
        return cats;
    }

    public static Set<Dog> createDogs() {
        Set<Dog> dogs = new HashSet<>();
        dogs.add(new Dog("Dog1"));
        dogs.add(new Dog("Dog2"));
        dogs.add(new Dog("Dog3"));
        return dogs;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs) {
        Set<Object> pets = new HashSet<>();
        pets.addAll(cats);
        pets.addAll(dogs);
        return pets;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats) {
        pets.removeAll(cats);
    }

    public static void printPets(Set<Object> pets) {
        for (Iterator iterator = pets.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
        System.out.println();
    }

    public static class Cat {
        private String name;

        Cat(String name) {
            this.name = name;
        }
    }

    public static class Dog {
        private String name;

        Dog(String name) {
            this.name = name;
        }
    }
}
