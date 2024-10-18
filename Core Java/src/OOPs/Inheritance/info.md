
## 1) Inheritance
Inheritance is a key concept in OOP where a child class can inherit and access properties and methods of its parent class.

- The parent class does not know about the child class.
- **Keyword**: `extends`

### Example:
```java
class A {  // parent class
    int a;
    A() {
        this.a = 1;
    }
    public void print() {
        System.out.println("Hello");
    }
}
class B extends A {  // child class
    B() {
        super();
    }
}

B b = new B();
b.print();  // Output: Hello
```

- If a method exists in the child class, it overrides the parent’s method. If not, the method from the parent class is called.

### Rules:
a) When invoking a child class constructor, always call the parent class constructor to initialize its properties.
- **Example**:
  ```java
  class A {
      int a;
      A() {
          this.a = 1;
      }
  }
  class B extends A {
      B() {
          super();
      }
  }
  ```

b) Private variables in the parent class cannot be accessed directly by the child class.
- **Example**:
  ```java
  class A {
      private int a;
  }
  class B extends A {
      a = 2;  // Error: Cannot access private variable
  }
  ```

**Solution**: Use getter and setter methods in the parent class to access private variables.


c) Referencing Parent Class to Child Class
The reference variable determines **which properties** you can access.

- **Example**:
  ```java
  Box box2 = new WeightedBox(1, 2, 3, 4);
  box2.displayBox();
  ```

    - `box2` → **Reference type** (`Box`)
    - `new WeightedBox(1, 2, 3, 4)` → **Object type** (`WeightedBox`)

- **box2** can only access properties and methods that belong to `Box`, even though the actual object is `WeightedBox`.
- **box2** **cannot** access `WeightedBox`-specific properties like `weight`. But if `displayBox()` is overridden in `WeightedBox`, it will use that version.

d) Cannot Reference Child Class to Parent Class
You cannot refer a child class to a parent class reference.

- **Example**:
  ```java
  WeightedBox weightedBox2 = new Box(2, 3, 4);  // Error
  ```

- **Reason**:
    - `weightedBox2` is a reference of the `WeightedBox` type, so it should have access to properties like `weight`.
    - However, the `Box()` constructor (parent type) cannot initialize the `weight` property since the parent class cannot access the child class’s constructor. Hence, it results in an error.

---

## Super Keyword
The `super` keyword is used to access the properties and methods of the parent class.

- **Example**:
  ```java
  int a = super.num;
  ```

- `super();` → Calls the method of the parent class.

### Rule:
a) Always call `super()` first to ensure the parent class is initialized before the child class, maintaining proper inheritance structure.


## Types of Inheritance in Java

Inheritance is a mechanism in Java where one class acquires the properties and behaviors of another class. It helps in code reusability and establishes a relationship between parent and child classes.

### 1. Single Inheritance
In single inheritance, a class (child) inherits from only one superclass (parent).
#### Example:
```java
class Box {
    int length, breadth, height;
}

class WeightBox extends Box {
    int weight;
}
```

### 2. Multilevel Inheritance
In multilevel inheritance, a class is derived from a class which is also derived from another class.
#### Example:
```java
class Box {
    int length, breadth, height;
}

class WeightBox extends Box {
    int weight;
}

class ShipmentBox extends WeightBox {
    int cost;
}
```

### 3. Hierarchical Inheritance
In hierarchical inheritance, multiple classes inherit from a single superclass.
#### Example:
```java
class Box {
    int length, breadth, height;
}

class WeightBox extends Box {
    int weight;
}

class ColorBox extends Box {
    String color;
}
```

### 4. Hybrid Inheritance
Java doesn’t support hybrid inheritance directly to avoid ambiguity and the diamond problem. However, it can be achieved using interfaces.

### Why Java Doesn’t Support Multiple Inheritance
Java does not support multiple inheritance with classes to avoid ambiguity and complexity caused by the diamond problem. This occurs when a class inherits from two classes that have methods with the same signature, leading to confusion about which method to execute. Instead, Java uses interfaces to provide multiple inheritance-like functionality.
