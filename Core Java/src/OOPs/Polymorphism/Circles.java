package OOPs.Polymorphism;

public class Circles extends Shapes{
    @Override
    void area() {
        System.out.println("Area is 3.14 * radius");
    }

    void area(float rad) {
        System.out.println("Area is square of side" + 3.14 * rad * rad);
    }
}
