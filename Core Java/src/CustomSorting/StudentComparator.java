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