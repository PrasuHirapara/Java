package OOPs.Abstraction;

public class Boy extends Parent{
    Boy(String name){
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

    @Override
    public void salary(int salary) {
        System.out.println("Boy salary " + salary);
    }
}
