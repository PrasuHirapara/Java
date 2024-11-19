package Comparator;

public class Student implements Comparable<Student> {
    int rollno;
    float marks;

    public Student(float marks, int rollno) {
        this.marks = marks;
        this.rollno = rollno;
    }

    @Override
    public String toString() {
        return rollno + " " + marks;
    }

    @Override
    public int compareTo(Student o) {
        return (int) ((int) this.marks - o.marks);
    }
}
