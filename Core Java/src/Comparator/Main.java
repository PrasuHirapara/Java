package Comparator;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Student student1 = new Student(90.4f, 12);
        Student student2 = new Student(87.9f, 13);

        if(student1.compareTo(student2) < 0){
            System.out.println("Student2 has higher marks");
        }else {
            System.out.println("Student has lower marks");
        }

        Student[] students = {new Student(88.5f, 101), new Student(78.0f, 99), new Student(92.0f, 102)};
        Arrays.sort(students, (a, b) -> a.toString().compareTo(b.toString()));

        System.out.println(Arrays.toString(students));
    }
}
