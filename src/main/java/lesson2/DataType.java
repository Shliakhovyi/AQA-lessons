package lesson2;

public class DataType {

    int documentId;

    public static void main(String[] args) {
        int i = 33;
        char c = 'a';
        float f = 47.54f;

        //int->char
        char toChar1 = (char) i;
        //float->char
        char toChar2 = (char) f;
        //float->char->int
        char toChar3 = (char) f;
        int toInt = (int) toChar3;

        int k = 23;
        final int STABLE = 123;
    }

    DataType (int documentId) {
        this.documentId=documentId;
    }
}
