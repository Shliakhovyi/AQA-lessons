package lesson6;

import java.util.Arrays;

public class Array {

    public static void main(String[] args) {
        char[] arr = new char[255];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) i;
        }

        String stringFor = Arrays.toString(arr);

        System.out.println(stringFor);

    }

}
