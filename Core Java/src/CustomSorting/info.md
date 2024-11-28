
# Comparator and Comparable in Java

## Comparator

### Description
`Comparator` is an interface in Java used to define custom sorting logic for objects. It is typically used when the natural ordering (provided by `Comparable`) is not sufficient or when multiple sorting criteria are required.

### When to Use
- Use `Comparator` when you want to sort objects based on a custom order.
- It is useful for sorting on multiple attributes or for applying different sorting orders (e.g., ascending and descending).
- Allows flexibility without altering the class itself.

### Example: Custom Sorting (Name, Marks, Roll Number)
This example demonstrates sorting a list of `StudentComparator` objects first by `name`, then by `marks`, and finally by `rollno`.

```java
package CustomSorting;

import java.util.Comparator;

public class StudentComparator implements Comparator<StudentComparator> {
    private String name;
    private int rollno;
    private float marks;

    public StudentComparator(String name, float marks, int rollno) {
        this.name = name;
        this.marks = marks;
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public int getRollno() {
        return rollno;
    }

    public float getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return name + " " + rollno + " " + marks;
    }

    @Override
    public int compare(StudentComparator s1, StudentComparator s2) {

        // Compare by marks
        int marksComparison = Float.compare(s2.getMarks(), s1.getMarks());
        if (marksComparison != 0) {
            return marksComparison;
        }
        // Compare by name
        int nameComparison = s1.getName().compareTo(s2.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }
        // Compare by roll number
        return Integer.compare(s1.getRollno(), s2.getRollno());
    }
}
```

## Comparable

### Description
`Comparable` is an interface in Java used to define the natural ordering of objects of a class. A class implementing this interface must override the `compareTo` method to define the sorting logic.

### When to Use
- Use `Comparable` when there is a single natural ordering for objects of a class.
- It is best suited for simple cases where the default sorting logic applies to all use cases.

### Example: Student Class Implementing Comparable

```java
package CustomSorting;

public class StudentComparable implements Comparable<StudentComparable> {
    private String name;
    private int rollno;
    private float marks;

    public StudentComparable(String name, float marks, int rollno) {
        this.name = name;
        this.marks = marks;
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public int getRollno() {
        return rollno;
    }

    public float getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return name + " " + rollno + " " + marks;
    }

    @Override
    public int compareTo(StudentComparable o) {
        return Float.compare(this.marks, o.marks);
    }
}
```

## Main Example Using Both Classes

```java
package CustomSorting;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // Comparator example
        ArrayList<StudentComparator> studentComparatorList = new ArrayList<>();
        studentComparatorList.add(new StudentComparator("Alice", 85.5f, 101));
        studentComparatorList.add(new StudentComparator("Bob", 90.0f, 102));
        studentComparatorList.add(new StudentComparator("Alice", 78.0f, 103));

        System.out.println("Before Sorting (Custom Order with Comparator):");
        for (StudentComparator student : studentComparatorList) {
            System.out.println(student);
        }

        studentComparatorList.sort(new StudentComparator(null, 0, 0));

        System.out.println("After Sorting (Custom Order with Comparator):");
        for (StudentComparator student : studentComparatorList) {
            System.out.println(student);
        }

        // Comparable example
        ArrayList<StudentComparable> studentComparableList = new ArrayList<>();
        studentComparableList.add(new StudentComparable("Alice", 85.5f, 101));
        studentComparableList.add(new StudentComparable("Bob", 90.0f, 102));
        studentComparableList.add(new StudentComparable("Charlie", 78.0f, 103));

        System.out.println("Before Sorting by Marks with Comparable:");
        for (StudentComparable student : studentComparableList) {
            System.out.println(student);
        }

        Collections.sort(studentComparableList);

        System.out.println("After Sorting by Marks with Comparable:");
        for (StudentComparable student : studentComparableList) {
            System.out.println(student);
        }
    }
}
```

## Difference Between Comparator and Comparable

| Aspect            | Comparator                                      | Comparable                 |
|--------------------|------------------------------------------------|----------------------------|
| **Purpose**        | Used for custom sorting logic.                 | Defines natural ordering for a class. |
| **Implementation** | Implemented in a separate class or as a lambda. | Implemented in the class itself. |
| **Method**         | `compare(Object o1, Object o2)`                | `compareTo(Object o)`      |
| **Flexibility**    | Provides flexibility for multiple sort orders. | One fixed sorting order.   |
| **Modification**   | Does not require modification of the class.    | Requires modification of the class. |
| **Usage**          | `Collections.sort(list, comparator)`           | `Collections.sort(list)`   |
| **Example Use Case** | Sorting by multiple attributes (e.g., name, marks, rollno). | Sorting by one attribute (e.g., marks). |
