package OOPs.Encapsulation;

public class Triangle extends Shapes {
    @Override
    void area() {
        System.out.println("Area is 0.5 * base * height");
    }
    void area(float height, float base) {
        System.out.println("Area is square of side" + 0.5 * base * height);
    }
}
