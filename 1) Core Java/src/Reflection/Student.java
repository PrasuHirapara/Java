package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Student {
    private final String name;
    private int age;
    static int total = 0;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        total++;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getTotal() {
        return total;
    }

    // Private method
    private void privatePrint() {
        System.out.println("Private method: print. Name = " + this.name);
    }

    // Static method
    public static void publicStaticPrint() {
        System.out.println("Public method: print. Total = " + total);
    }
}