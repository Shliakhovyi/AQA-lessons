package lesson7;

public class MainForBox {
    public static void main(String[] args) {
        Box myBox = new Box(10, 10, 10);
        Box cube = new Box(10, 10, 10);
        Box parallelepiped = new Box(10, 20 ,10);


        cube.getVolume();
        parallelepiped.getVolume();

        HeavyBox heavyBox = new HeavyBox();

        Box box = new HeavyBox();
    }
}