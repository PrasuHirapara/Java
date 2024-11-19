package OOPs.Abstraction;

public abstract class Parent {
    String name;

    abstract void career(String name);
    abstract void age(int age);

//    abstract static void staticMethod();
    static void staticMethod() {
        System.out.println("static method");
    }

    public void salary(int salary) {
        System.out.println("Prent: " + salary);
    }
}
