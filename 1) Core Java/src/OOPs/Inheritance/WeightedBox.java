package OOPs.Inheritance;

public class WeightedBox extends Box{
    double weight;

    WeightedBox() {
        this.weight = 0;
    }

    WeightedBox(double length, double width, double height, double weight) {
        // used to inti value in parent class
        super(length, width, height);
        this.weight = weight;
    }

    public void displayBox() {
        System.out.println("Weight is " + this.weight);
    }
}
