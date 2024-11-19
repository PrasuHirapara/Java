package OOPs.Abstraction;

public class Main {
    public static void main(String[] args) {
        Parent boy = new Boy("Boy");
        Parent girl = new Girl("Girl");

        boy.career("Coder boy");
        girl.career("Coder girl");

        boy.age(34);
        girl.age(30);

        boy.salary(3455);
        girl.salary(2355);

        System.out.println(boy.name);
        System.out.println(girl.name);

        Parent.staticMethod();
    }
}
