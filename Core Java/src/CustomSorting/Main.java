package CustomSorting;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        // Comparator example
        ArrayList<StudentComparator> studentComparatorList = new ArrayList<>();
        studentComparatorList.add(new StudentComparator("Prasu", 93.5f, 101));
        studentComparatorList.add(new StudentComparator("Preet", 90.0f, 102));
        studentComparatorList.add(new StudentComparator("Rudra", 78.0f, 103));

        studentComparatorList.sort(new StudentComparator(null, 0, 0));

        System.out.println("After Sorting (Custom Order with Comparator):");
        for (StudentComparator student : studentComparatorList) {
            System.out.println(student);
        }

        System.out.printf("\n");

        // Comparable example
        ArrayList<StudentComparable> studentComparableList = new ArrayList<>();
        studentComparableList.add(new StudentComparable("Prasu", 93.5f, 101));
        studentComparableList.add(new StudentComparable("Preet", 90.0f, 102));
        studentComparableList.add(new StudentComparable("Rudra", 78.0f, 103));

        Collections.sort(studentComparableList);

        System.out.println("After Sorting by Marks with Comparable:");
        for (StudentComparable student : studentComparableList) {
            System.out.println(student);
        }
    }
}