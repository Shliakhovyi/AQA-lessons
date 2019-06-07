package lesson6;

public class TaskLessonOne {

    public static void main(String[] args) {

        int ar[] = {2,3,-1,6,6,6,7,8,9,0,1111};

        int max = 0;
        for(int k = 0; k <= ar.length; k++) {
            if (ar[k] > ar[k+1]) {
                max = ar[k];
                System.out.println(max);
            } else {
                max = ar[k+1];
            }
        }
    }
}
