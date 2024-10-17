package OOPs.Class;

public class Main {
    public static void main(String[] args) {
        Student prasu;
        prasu = new Student();

        Student student = new Student(1, "Student", 80);
        Student student2 = new Student(1, "Student", 80);
        Student student3 = new Student(1, "Student", 80);

        System.out.println(prasu.name);
        System.out.println(Student.total);

        Integer a = 10;
        int b = Integer.valueOf("2");

        System.out.println(a + " " + b);
    }
}