
# Interface
An interface in Java is used for achieving abstraction by defining a set of methods that a class must implement, without providing the method implementations.

## Solving Multiple Inheritance Problem
Interfaces in Java help to solve the multiple inheritance problem by allowing a class to implement multiple interfaces, each providing different functionality, without the ambiguity of method inheritance.

## Rules for Interface
1. Interfaces can only contain abstract methods (until Java 8 introduced default and static methods).
2. A class can implement multiple interfaces.
3. All methods in an interface are implicitly `public` and `abstract`.
4. Variables in an interface are implicitly `public`, `static`, and `final`.
5. Interfaces can extend other interfaces.
6. Nested interfaces are allowed.

## Example of Interface Usage

```java
// Interface for engine functionalities
interface Engine {
    int price = 9999; // final and static
    void start();
    void stop();
    void accelerate();
}

// Interface for brake functionalities
interface Brake {
    void brake();
}

// Interface for media functionalities
interface Media {
    void unpause();
    void pause();
}

// Implementation class for the functionalities
class Car implements Engine, Brake, Media {
    @Override
    public void start() {
        System.out.println("Engine starting...");
    }

    @Override
    public void stop() {
        System.out.println("Engine stopping...");
    }

    @Override
    public void accelerate() {
        System.out.println("Engine accelerating...");
    }

    @Override
    public void brake() {
        System.out.println("Car braking...");
    }

    @Override
    public void unpause() {
        System.out.println("song unpaused...");
    }

    @Override
    public void pause() {
        System.out.println("song paused...");
    }
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.start();
        myCar.accelerate();
        myCar.brake();
        myCar.stop();
    }
}
```
## Body in interface (after Java 8)
-Using default access modifier.
-You can not override default method else will give error.
```java
public interface Engine {

    int price = 99999;

    default void start() {
        System.out.println("Starting Engine default");
    }
    void stop();
    void accelerate();
}

```

## Difference between Abstract Class and Interface

| Feature                 | Abstract Class           | Interface                         |
|-------------------------|--------------------------|------------------------------------|
| Inheritance              | Single inheritance       | Multiple inheritance supported    |
| Method Types             | Both abstract and concrete | Only abstract (until Java 8)     |
| Access Modifiers         | Can have any access      | Only `public` and `abstract`      |
| Variables                | Instance variables       | `public`, `static`, `final` only  |
| Use Case                 | Partial implementation   | Full abstraction                  |

## Static Methods in Interface
Interfaces can have static methods from Java 8. These methods belong to the interface and not the class implementing it.

```java
interface Utility {
    static void display() {
        System.out.println("Static method in interface");
    }
}

public class Main {
    public static void main(String[] args) {
        // Calling static method from the interface
        Utility.display(); // Output: Static method in interface
    }
}

```

## Nested Interface
An interface can be nested within another interface or class.

```java
class OuterClass {
    interface InnerInterface {
        void display();
    }
}
class Test implements OuterClass.InnerInterface {
    @Override
    public void display() {
        System.out.println("Implementing nested interface");
    }
}
```

## Extending Interfaces
An interface can extend other interfaces.

```java
interface SuperInterface1 {
    void method1();
}

interface SuperInterface2 {
    void method2();
}

interface SubInterface extends SuperInterface1, SuperInterface2 {
    void method3();
}

// Class implementing SubInterface
class ImplementingClass implements SubInterface {
    @Override
    public void method1() {
        System.out.println("Method 1 from SuperInterface1");
    }

    @Override
    public void method2() {
        System.out.println("Method 2 from SuperInterface2");
    }

    @Override
    public void method3() {
        System.out.println("Method 3 from SubInterface");
    }
}

```