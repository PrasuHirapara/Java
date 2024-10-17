package OOPs.Inheritance;

public class Main {
    public static void main(String[] args) {
        Box box = new Box(23,4,12);
        box.displayBox();

        WeightedBox weightedBox = new WeightedBox(23, 4, 12, 34);
        weightedBox.displayBox();

        Box box2 = new WeightedBox(1, 2, 3, 4);
        box2.displayBox();
//        System.out.println(box2.weight); //error

        // error -> referring child class to parent class.
//        WeightedBox weightedBox2 = new Box(2, 3, 4);


    }
}
