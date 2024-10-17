
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

### Types of Inheritance
