package Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Instantiate Student object and get its Class
        Student student = new Student("Prasu", 19);
        Class<?> studentClass = student.getClass();
        String className = studentClass.getName();
        System.out.println("Class Name: " + className);

        // Print all fields, including private fields
        Field[] fields = studentClass.getDeclaredFields();
        System.out.println("Fields: " + Arrays.toString(fields));
        for (Field field : fields) {
            field.setAccessible(true); // Make private fields accessible
            System.out.println("Field Name: " + field.getName());
            System.out.println("Field Type: " + field.getType());

            // Modify and access specific fields
            try {
                if (field.getName().equals("name")) {
                    field.set(student, "Prasu Updated");
                    System.out.println("Updated Name: " + field.get(student));
                }
                if (field.getName().equals("age")) {
                    field.setInt(student, 20);
                    System.out.println("Updated Age: " + field.get(student));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // List and invoke public methods
        System.out.println("\nPublic Methods:");
        Method[] methods = studentClass.getMethods();
        for (Method method : methods) {
            System.out.println("Method Name: " + method.getName());
            System.out.println("Return Type: " + method.getReturnType());
            System.out.println("Parameters: " + Arrays.toString(method.getParameterTypes()));

            // Invoke static method
            if (method.getName().equals("publicStaticPrint")) {
                try {
                    method.invoke(null);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        // Access private method and invoke it
        try {
            Method privateMethod = studentClass.getDeclaredMethod("privatePrint");
            privateMethod.setAccessible(true);
            privateMethod.invoke(student);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // Print constructors
        System.out.println("\nConstructors:");
        Constructor<?>[] constructors = studentClass.getConstructors();
        for (Constructor<?> cons : constructors) {
            System.out.println("Constructor: " + cons);
            System.out.println("Parameters: " + Arrays.toString(cons.getParameterTypes()));
        }

        // Print class modifiers
        System.out.println("\nClass Modifiers: " + Modifier.toString(studentClass.getModifiers()));
        System.out.println("Is Public: " + Modifier.isPublic(studentClass.getModifiers()));

        // List interfaces implemented by Student
        Class<?>[] interfaces = studentClass.getInterfaces();
        System.out.println("Interfaces: " + Arrays.toString(interfaces));
    }
}