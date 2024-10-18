package OOPs.Encapsulation;

public class Square extends Shapes {
    @Override
    void area() {
        System.out.println("Area is square of side");
    }
    void area(float side) {
        System.out.println("Area is square of side"+ 4 * side);
    }
}
