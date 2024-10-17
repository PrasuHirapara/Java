package OOPs.Inheritance;

public class Box {
    double length;
    double width;
    double height;

    Box(){
        this.length = 0.0;
        this.width = 0.0;
        this.height = 0.0;
    }

    Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public void displayBox(){
        System.out.println("Length: " + this.length + " Width: " + this.width + " Height: " + this.height);
    }
}
