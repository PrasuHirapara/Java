package OOPs.Class;

public class Main {
    int a;
    Main(int a) {
        this.a = a;
    }

//    from Object class
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        return this.a == ((Main) obj).a;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

//    deprecated
//    @Override
//    public void finalize() throws Throwable {
//        super.finalize();
//    }

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

        Main main = new Main(1);
        Main main2 = new Main(1);

        System.out.println(main.hashCode());
        System.out.println(main == main2); // false -> checks for memory
        System.out.println(main.equals(main2)); // without modification -> false

        System.out.println(main instanceof Main);

        System.out.println(main.getClass());
        System.out.println(main.getClass().getSuperclass());
    }
}