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