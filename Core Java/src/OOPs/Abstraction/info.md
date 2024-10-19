# Abstraction
Abstraction is the concept of hiding the internal details and showing only the functionality to the user.

## What is an Abstract Class?
An abstract class is a class that cannot be instantiated directly and may contain abstract methods that must be implemented by its subclasses.
It tells what to do not how to do.

## What is an Abstract Method?
An abstract method is a method that is declared without an implementation and must be overridden by the subclasses of the abstract class.
Does not have body.

## Example of Abstract Class and Abstract Method

```java
// Abstract class
abstract class Parent {
    // Abstract method
    public abstract void career();
}

// Child class 1
class Boy extends Parent {
    @Override
    public void career() {
        System.out.println("I want to be an engineer.");
    }
}

// Child class 2
class Girl extends Parent {
    @Override
    public void career() {
        System.out.println("I want to be a doctor.");
    }
}

public class Main {
    public static void main(String[] args) {
        Parent boy = new Boy();
        boy.career(); // Output: I want to be an engineer.

        Parent girl = new Girl();
        girl.career(); // Output: I want to be a doctor.
    }
}
```

## Rules for Abstract Class

1. An abstract class cannot be instantiated.
2. An abstract class can have both abstract and non-abstract (concrete) methods.
3. Subclasses must implement all abstract methods or be declared abstract themselves.
4. Abstract classes can have constructors and member variables and can be accessed by super() keyword.
5. Abstract classes can implement interfaces.
6. Can not crate abstract static method because abstract method must be overriden and static method can not be overriden.
7. Instead you can create only static method as they does not depend upon Object.
    Ex: 
```java
public abstract class Parent {
    String name;
    
    abstract void career(String name);
    abstract void age(int age);

    //    abstract static void staticMethod(); // error
    static void staticMethod() {
        System.out.println("static method");
    }
    public void salary(int salary) {
        System.out.println("Prent: " + salary);
    }
}
```