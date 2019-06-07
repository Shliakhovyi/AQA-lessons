package lesson1;

public class BubbleSort {

    public static void main(String[] args) {

        int[] array = {8, 7, 6, 3, 4, 1};

        boolean reverted;
        for (int i = 0; i <= array.length; i++) {
            reverted = false;
            for (int k = 0; k < array.length - k; k++) {
                if (array[k] > array[k+1]) {
                    int temp = array[k+1];
                    array[k+1] = array[k];
                    array[k] = temp;
                    reverted = true;
                }
            }
            if (!reverted) {
                break;
            }
        }
        for (int j: array) {
            System.out.println(j);
        }
    }

}
