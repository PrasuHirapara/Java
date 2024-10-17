package OOPs.Class;

public class Student {
    int num;
    String name;
    static int total;

    static {
        total = 0;
        System.out.println("Will run once");
    }

    Student() {
        System.out.println("Empty Constructor");
        Student.total += 1;
    }

    Student(int num, String name, float marks) {
        this.num = num;
        this.name = name;
        Student.total += 1;
    }

    public static void getStudent() {
        System.out.println("Inside get student method");
    }
}
