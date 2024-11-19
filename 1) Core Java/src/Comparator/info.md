
# Comparator
`Comparator` is an interface in Java used to define custom orderings for objects, allowing you to sort collections or arrays in a way different from their natural ordering.

## Syntax
The basic syntax to use `Comparator` is:

```java
class ClassName implements Comparator<ClassName> {
    @Override
    public int compare(ClassName o1, ClassName o2) {
        // comparison logic
    }
}
```

## Rules for Comparator
- You must override the `compare(T o1, T o2)` method to provide custom sorting logic.
- Return a negative integer, zero, or a positive integer when the first argument is less than, equal to, or greater than the second.
- You can use `Comparator` to sort objects in multiple ways, unlike `Comparable`, which defines a single natural order.

## Example: Student Class Implementing Comparable
Here's an example of a class `Student` that implements the `Comparable<Student>` interface:

```java
public class Student implements Comparable<Student> {
    int rollno;
    float marks;

    public Student(float marks, int rollno) {
        this.marks = marks;
        this.rollno = rollno;
    }

    @Override
    public int compareTo(Student o) {
        return (int) (this.marks - o.marks);
    }
}
```

In the example above, the `compareTo` method compares students based on their `marks`. The sorting can be done using `Arrays.sort()`.


## Sorting Objects Using `toString()` and `compareTo()`
You can also sort objects based on their string representations using the `toString()` method and `Arrays.sort()`.

### Example:

```java
Student[] students = {new Student(88.5f, 101), new Student(78.0f, 99), new Student(92.0f, 102)};

Arrays.sort(students, (a, b) -> a.toString().compareTo(b.toString()));
```

In this example, the objects are sorted based on their string representations, as defined by the `toString()` method.
