package OOPs.Polymorphism;

public class Main {
    public static void main(String[] args) {
        Shapes shapes = new Shapes();
        Circles circles = new Circles();
        Square square = new Square();

        shapes.area();
        circles.area();
        square.area();

        shapes.area(244);
        circles.area(12);
        square.area(23);
    }
}
