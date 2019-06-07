package lesson7;

public class Box {
    public double width;
    public double height;
    public double depth;

    public Box(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public Box () {

    }

    public double getVolume() {
        return width * height * depth;
    }

    public void setDim(int w, int h, int d) {
        width = w;
        height = h;
        depth = d;
    }

    public void printInfo(){
        System.out.println("Объем коробки: "+getVolume());
    }
}
