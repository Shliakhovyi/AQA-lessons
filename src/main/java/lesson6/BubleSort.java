package lesson6;

public class BubleSort {


    public static void main(String[] args) {
        int[] array = {5, 1, 3, 7, 2, 4, 8};

        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int k = 0; k <= array.length - k; k++) {
                if (array[k] < array[k+1]) {
                    temp = array[k];
                    array[k] = array[k+1];
                    array[k+1] = temp;
                }
            }
        }

       for (int t : array) {
            System.out.println(t + " ");
        }

    }
}
