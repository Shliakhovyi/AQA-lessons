package lesson7;

public class Convert {
    public static void main(String[] args) {
        int i = 123;
        double d = 23.43;
        long l = 4324234;
        boolean b = true;

        String str = String.valueOf(i);
        String str2 = String.valueOf(d);
        String str3 = String.valueOf(l);
        String str4 = String.valueOf(b);

        int i2 = Integer.valueOf(str);
        double d2 = Double.valueOf(str2);
        long l2 = Long.valueOf(str3);
        boolean b2 = Boolean.valueOf(str4);

        System.out.println(i2);
        System.out.println(d2);
        System.out.println(l2);
        System.out.println(b2);
    }
}
