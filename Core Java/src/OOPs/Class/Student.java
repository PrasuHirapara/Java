package OOPs.Class;

public class Student {
    int num;
    String name;

    Student() {
        System.out.println("Empty Constructor");
    }

    Student(int num, String name, float marks) {
        this.num = num;
        this.name = name;
    }
}
