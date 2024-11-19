package OOPs.Abstraction;

public class Girl extends Parent{
    public Girl(String name) {
        this.name = name;
    }

    @Override
    void career(String name) {
        System.out.println("I want to be " + name);
    }

    @Override
    void age(int age) {
        System.out.println("I am " + age + " years old");
    }
}
